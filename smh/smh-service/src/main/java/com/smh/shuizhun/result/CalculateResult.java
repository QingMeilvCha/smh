package com.smh.shuizhun.result;

import lombok.Data;

import java.util.List;

/**
 * 计算结果实体类
 * Created by zhouyuhang on 2019/4/12.
 */
@Data
public class CalculateResult {
    public String calculateID;
    public List<com.smh.shuizhun.model.HVResults> HVResults;
    public List<com.smh.shuizhun.model.ALResults> ALResults;
    public double derta;//单位权中误差
}
