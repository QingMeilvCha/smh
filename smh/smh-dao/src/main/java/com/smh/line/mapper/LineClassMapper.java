package com.smh.line.mapper;

import com.smh.shuizhun.model.LineClass;

import java.util.List;

/**
 * Created by MSI on 2019/4/22.
 */
public interface LineClassMapper {
    List<LineClass> selectEntity();

    void insertBatch(List<LineClass> lineClasses);
}
