package com.smh.shuizhun;


/**
 * Created by zhouyuhang on 2019/4/11.
 */
public class Matrix {
    private double[][] matrix;
    private int row = 0, col = 0;
    public Matrix(int row)
    {
        matrix = new double[row][row];
    }
    public Matrix(int row, int col)
    {
        this.row = row;
        this.col = col;
        matrix = new double[row][col];
    }
    //复制构造函数
    public Matrix(Matrix m)
    {
        int row = m.row;
        int col = m.col;
        matrix = new double[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix[i][j] = m.getNum(i, j);
    }
    //输入相应的值，对矩阵进行设置
    public void SetNum(int i, int j, double num)
    {
        matrix[i][ j] = num;
    }
    //得到相应的矩阵某个数
    public double getNum(int i, int j)
    {
        return matrix[i][j];
    }
    public void OutputM()
    {
    }
    public void InputM(int Row, int Col)
    {
        //省略
    }
    //得到matrix
    private double[][] Detail;
    public double[][] getDetail()
    {
        return this.matrix;
    }
    public void setDetail(double[][] value){
        matrix = value;
    }
    //矩阵转置实现
    public Matrix Transpose()
    {
        Matrix another = new Matrix(col, row);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                another.SetNum(j, i, matrix[i][j]);
            }
        }
        return another;
    }
    //矩阵相加实现
    public static Matrix Add(Matrix Lm, Matrix Rm) throws Exception
    {
        if (Lm.row != Rm.row)
        {
            Exception e = new Exception("相加的两个矩阵的行数不等");
            throw e;
        }
        if (Lm.col != Rm.col)
        {
            Exception e = new Exception("相加的两个矩阵的列数不等");
            throw e;
        }
        Matrix another = new Matrix(Lm.row, Lm.col);
        for (int i = 0; i < Lm.row; i++)
        {
            for (int j = 0; j < Lm.col; j++)
            {
                double temp = Lm.getNum(i, j) + Rm.getNum(i, j);
                another.SetNum(i, j, temp);
            }
        }
        return another;
    }
    //矩阵相加实现
    public static Matrix subtraction(Matrix Lm, Matrix Rm) throws Exception
    {
        if (Lm.row != Rm.row)
        {
            Exception e = new Exception("相减的两个矩阵的行数不等");
            throw e;
        }
        if (Lm.col != Rm.col)
        {
            Exception e = new Exception("相减的两个矩阵的列数不等");
            throw e;
        }
        Matrix another = new Matrix(Lm.row, Lm.col);
        for (int i = 0; i < Lm.row; i++)
        {
            for (int j = 0; j < Lm.col; j++)
            {
                double temp = Lm.getNum(i, j) - Rm.getNum(i, j);
                another.SetNum(i, j, temp);
            }
        }
        return another;
    }
    //矩阵相乘实现
    public static Matrix Mutiply(Matrix m1, Matrix m2) throws Exception
    {
        double temp = 0;
        Matrix ret;
        if (m1.col != m2.row)
        {
            Exception e = new Exception("前矩阵列数不等于后矩阵行数,无法相乘");
            throw e;
        }
        ret = new Matrix(m1.row, m2.col);
        double a, b;
        for (int i = 0; i < m1.row; i++)
        {
            for (int j = 0; j < m2.col; j++)
            {
                temp = 0;
                for (int p = 0; p < m1.col; p++)
                {
                    a = m1.getNum(i, p);
                    b = m2.getNum(p, j);
                    temp += m1.getNum(i, p) * m2.getNum(p, j);
                }
                ret.SetNum(i, j, temp);
            }
        }
        return ret;
    }
    //矩阵求逆实现
    public static Matrix Inverse(Matrix M) throws Exception
    {
        int m = M.row;
        int n = M.col;
        if (m != n)
        {
            Exception myException = new Exception("求逆的矩阵不是方阵，不能求逆");
            throw myException;
        }
        Matrix ret = new Matrix(m, n);
            double[][] a0 = M.getDetail();
            double[][] a = a0;
            double[][] b = ret.getDetail();

        int i, j, row, k;
        double max, temp;
        //单位矩阵
        for (i = 0; i < n; i++)
        {
            b[i][ i] = 1;
        }
        for (k = 0; k < n; k++)
        {
            max = 0; row = k;
            //找最大元，其所在行为row
            for (i = k; i < n; i++)
            {
                temp = Math.abs(a[i][ k]);
                if (max < temp)
                {
                    max = temp;
                    row = i;
                }
                if (max == 0)
                {
                    Exception myException = new Exception("该矩阵无法求逆");
                    throw myException;
                }
                //交换k与row行
                if (row != k)
                {
                    for (j = 0; j < n; j++)
                    {
                        temp = a[row][ j];
                        a[row][ j] = a[k][ j];
                        a[k][j] = temp;
                    }
                }
                //首元化为1
                for (j = k + 1; j < n; j++) a[k][j] /= a[k][k];
                for (j = 0; j < n; j++) b[k][ j] /= a[k][k];

                a[k][ k] = 1;
                //k列化为0
                //对a
                for (j = k + 1; j < n; j++)
                {
                    for (i = 0; i < k; i++) a[i][ j] -= a[i][ k] * a[k][ j];
                    for (i = k + 1; i < n; i++) a[i][j] -= a[i][k] * a[k][j];
                }
                //对b
                for (j = 0; j < n; j++)
                {
                    for (i = 0; i < k; i++) b[i][j] -= a[i][k] * b[k][j];
                    for (i = k + 1; i < n; i++) b[i][j] -= a[i][k] * b[k][j];
                }
                for (i = 0; i < n; i++) a[i][k] = 0;
                a[k][k] = 1;
            }

        }
        return ret;

    }
}


