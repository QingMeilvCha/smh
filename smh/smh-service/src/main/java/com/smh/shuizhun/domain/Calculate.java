package com.smh.shuizhun.domain;

import com.smh.shuizhun.AdjustLevel;
import com.smh.shuizhun.result.ALResults;
import com.smh.shuizhun.result.CalculateResult;
import com.smh.shuizhun.LPointClass;
import com.smh.shuizhun.LineClass;
import com.smh.shuizhun.result.HVResults;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理水准网数据核心类
 * Created by zhouyuhang on 2019/4/12.
 */
public class Calculate {
    private  List<LPointClass> ControlPoints = new ArrayList<>();
    private  List<LPointClass> CurrentPoints = new ArrayList<>();
    private  List<LineClass> CurrentSegments = new ArrayList<>();
    private CalculateResult calculateResult;

    public CalculateResult getCalculateResult(){
        return this.calculateResult;
    }

    public Calculate(List<LPointClass> controlPoints, List<LPointClass> currentPoints, List<LineClass> currentSegments) {
        ControlPoints = controlPoints;
        CurrentPoints = currentPoints;
        CurrentSegments = currentSegments;
    }

    public void doAdjustLevel() throws Exception
    {

        //实例化一个平差类
        AdjustLevel MyAdjust = new AdjustLevel();
        //调用该类的平差方法
        MyAdjust.LevelAdjust(CurrentSegments, CurrentPoints, ControlPoints);
        //调用该类的字段（字段值在类外部不能修改）
        calculateResult.setDerta(MyAdjust.getDerta());
        List<ALResults> ALResults=new ArrayList<>();
        for (LPointClass CP1 : CurrentPoints)
        {
            if (CP1.IsControlP == false)
            {
                ALResults alResults = new ALResults();
                alResults.setPID(CP1.PID.toString());
                alResults.setAL(CP1.H);
                ALResults.add(alResults);
            }
        }
        calculateResult.setALResults(ALResults);
    }

    //待定点高程计算
    private void doCaculateH() {
        CaculateH(CurrentPoints, CurrentSegments);
        ControlPoints.clear();
        //净化控制点（去除非水准网中的控制点）
        for (LPointClass P : CurrentPoints)
        {
            if (P.IsControlP == true)
            {
                ControlPoints.add(P);
            }
        }
    }

    public void CaculateH(List<LPointClass> CurrentPoints, List<LineClass> CurrentSegments)
    {
        //临时变量
//        String temp, temps;
        int Index = 0;
        //当前点有高程的个数
        int CP = 0;
        //当前点没有高程的个数
        int DP = 0;
        do
        {
            for (LineClass Tline : CurrentSegments)
            {   //获取最新的点信息
                Index = Belong(CurrentPoints, Tline.SP.PID);
                Tline.SP.H = CurrentPoints.get(Index).H;
                Tline.SP.IsControlP = CurrentPoints.get(Index).IsControlP;
                Tline.SP.IsH0 = CurrentPoints.get(Index).IsH0;

                Index = Belong(CurrentPoints, Tline.EP.PID);
                Tline.EP.H = CurrentPoints.get(Index).H;
                Tline.EP.IsControlP = CurrentPoints.get(Index).IsControlP;
                Tline.EP.IsH0 = CurrentPoints.get(Index).IsH0;
                if (Tline.SP.IsH0 == true && Tline.EP.IsH0 == false)
                {
                    Tline.EP.H = Tline.SP.H + Tline.dH;
                    Tline.EP.IsH0 = true;
                    Index = Belong(CurrentPoints, Tline.EP.PID);
                    CurrentPoints.get(Index).H = Tline.EP.H;
                    CurrentPoints.get(Index).IsH0 = true;
                }
                if (Tline.SP.IsH0 == false && Tline.EP.IsH0 == true)
                {
                    Tline.SP.H = Tline.EP.H - Tline.dH;
                    Tline.SP.IsH0 = true;
                    Index = Belong(CurrentPoints, Tline.SP.PID);
                    CurrentPoints.get(Index).H = Tline.SP.H;
                    CurrentPoints.get(Index).IsH0 = true;
                }
            }
            CP = 0;
            for (LPointClass P : CurrentPoints)
            {
                if (P.IsH0 == true)
                    CP++;

            }
            DP = CurrentPoints.size() - CP;

        } while (DP > 0);
        List<HVResults> HVResults=new ArrayList<>();
        for (LPointClass CP1 : CurrentPoints)
        {
            HVResults hvResults = new HVResults();
            hvResults.setPID(CP1.PID.toString());
            hvResults.setHV(CP1.H);
            hvResults.setIsControlP(CP1.IsControlP);
            hvResults.setIsH0(CP1.IsH0);
            HVResults.add(hvResults);
        }
        calculateResult.setHVResults(HVResults);
    }

    private static int Belong(List<LPointClass> CurrentPoints, String s)
    {
        for (LPointClass TPoint : CurrentPoints)
        {
            if (TPoint.PID == s)
                return CurrentPoints.indexOf(TPoint);
        }
        return -1;
    }
}
