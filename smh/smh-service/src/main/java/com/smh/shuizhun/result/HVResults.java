package com.smh.shuizhun.result;

import lombok.Data;


/**
 * 高程初始值计算结果
 * Created by zhouyuhang on 2019/4/12.
 */
@Data
public class HVResults {
    public String PID;
    public double HV;
    //是否是控制点
    public boolean IsControlP;
    //是否有初始高程
    public boolean IsH0;
}
