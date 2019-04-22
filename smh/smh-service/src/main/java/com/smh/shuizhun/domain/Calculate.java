package com.smh.shuizhun.domain;

import com.smh.shuizhun.AdjustLevel;
import com.smh.shuizhun.model.ALResults;
import com.smh.shuizhun.result.CalculateResult;
import com.smh.shuizhun.model.LPointClass;
import com.smh.shuizhun.model.LineClass;
import com.smh.shuizhun.model.HVResults;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理水准网数据核心类
 * Created by zhouyuhang on 2019/4/12.
 */
@Component
public class Calculate {
//    private  List<LPointClass> ControlPoints = new ArrayList<>();
//    private  List<LPointClass> CurrentPoints = new ArrayList<>();
//    private  List<LineClass> CurrentSegments = new ArrayList<>();
    private CalculateResult calculateResult=new CalculateResult();

    public CalculateResult getCalculateResult(){
        return this.calculateResult;
    }

//    public Calculate(List<LPointClass> controlPoints, List<LPointClass> currentPoints, List<LineClass> currentSegments) {
//        ControlPoints = controlPoints;
//        CurrentPoints = currentPoints;
//        CurrentSegments = currentSegments;
//    }

    public void doAdjustLevel(List<LPointClass> ControlPoints, List<LPointClass> CurrentPoints, List<LineClass> CurrentSegments) throws Exception
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
            if (CP1.isControlP == false)
            {
                ALResults alResults = new ALResults();
                alResults.setPid(CP1.pid.toString());
                alResults.setAl(CP1.h);
                ALResults.add(alResults);
            }
        }
        calculateResult.setALResults(ALResults);
        calculateResult.setDerta(MyAdjust.getDerta());
    }

    //待定点高程计算
    public void doCaculateH(List<LPointClass> ControlPoints, List<LPointClass> CurrentPoints, List<LineClass> CurrentSegments) {
        CaculateH(CurrentPoints, CurrentSegments);
        ControlPoints.clear();
        //净化控制点（去除非水准网中的控制点）
        for (LPointClass P : CurrentPoints)
        {
            if (P.isControlP == true)
            {
                ControlPoints.add(P);
            }
        }
    }

    public void CaculateH(List<LPointClass> CurrentPoints, List<LineClass> CurrentSegments)
    {
        int Index = 0;
        //当前点有高程的个数
        int CP = 0;
        //当前点没有高程的个数
        int DP = 0;
        do
        {
            for (LineClass Tline : CurrentSegments)
            {   //获取最新的点信息
                Index = Belong(CurrentPoints, Tline.sPid.pid);
                Tline.sPid.h = CurrentPoints.get(Index).h;
                Tline.sPid.isControlP = CurrentPoints.get(Index).isControlP;
                Tline.sPid.isH0 = CurrentPoints.get(Index).isH0;

                Index = Belong(CurrentPoints, Tline.ePid.pid);
                Tline.ePid.h = CurrentPoints.get(Index).h;
                Tline.ePid.isControlP = CurrentPoints.get(Index).isControlP;
                Tline.ePid.isH0 = CurrentPoints.get(Index).isH0;
                if (Tline.sPid.isH0 == true && Tline.ePid.isH0 == false)
                {
                    Tline.ePid.h = Tline.sPid.h + Tline.dh;
                    Tline.ePid.isH0 = true;
                    Index = Belong(CurrentPoints, Tline.ePid.pid);
                    CurrentPoints.get(Index).h = Tline.ePid.h;
                    CurrentPoints.get(Index).isH0 = true;
                }
                if (Tline.sPid.isH0 == false && Tline.ePid.isH0 == true)
                {
                    Tline.sPid.h = Tline.ePid.h - Tline.dh;
                    Tline.sPid.isH0 = true;
                    Index = Belong(CurrentPoints, Tline.sPid.pid);
                    CurrentPoints.get(Index).h = Tline.sPid.h;
                    CurrentPoints.get(Index).isH0 = true;
                }
            }
            CP = 0;
            for (LPointClass P : CurrentPoints)
            {
                if (P.isH0 == true)
                    CP++;

            }
            DP = CurrentPoints.size() - CP;

        } while (DP > 0);
        List<HVResults> HVResults=new ArrayList<>();
        for (LPointClass CP1 : CurrentPoints)
        {
            HVResults hvResults = new HVResults();
            hvResults.setPid(CP1.pid.toString());
            hvResults.setHv(CP1.h);
            hvResults.setControlP(CP1.isControlP);
            hvResults.setH0(CP1.isH0);
            HVResults.add(hvResults);
        }
        calculateResult.setHVResults(HVResults);
    }

    private static int Belong(List<LPointClass> CurrentPoints, String s)
    {
        for (LPointClass TPoint : CurrentPoints)
        {
            if (TPoint.pid .equals(s) ) {
                return CurrentPoints.indexOf(TPoint);
            }
        }
        return -1;
    }
}
