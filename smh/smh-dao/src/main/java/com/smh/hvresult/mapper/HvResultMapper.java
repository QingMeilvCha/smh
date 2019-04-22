package com.smh.hvresult.mapper;

import com.smh.shuizhun.model.HVResults;

import java.util.List;

/**
 * Created by MSI on 2019/4/22.
 */
public interface HvResultMapper {
    List<HVResults> selectEntity();
    void insertBatch(List<HVResults> hvResults);
}
