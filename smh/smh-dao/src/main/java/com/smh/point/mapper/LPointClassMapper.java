package com.smh.point.mapper;

import com.smh.shuizhun.model.LPointClass;

import java.util.List;

/**
 * Created by MSI on 2019/4/21.
 */
public interface LPointClassMapper {

List<LPointClass> selectEntity();

void insertBatch(List<LPointClass> lPointClasses);
}
