package com.smh.alresult.mapper;

import com.smh.shuizhun.model.ALResults;

import java.util.List;

/**
 * Created by MSI on 2019/4/22.
 */
public interface AlResultMapper {
    void insert(ALResults alResults);

    void insertBatch(List<ALResults> alResults);
}
