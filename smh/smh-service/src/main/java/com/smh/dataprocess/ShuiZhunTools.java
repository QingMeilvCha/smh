package com.smh.dataprocess;

import com.smh.sys.SysConstants;
import com.smh.taskdata.model.TaskDataEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhouyuhang on 2018/12/26.
 */
@Component
public class ShuiZhunTools {

    /**
     * 计算每一个测站数据
     * @param taskDataEntities
     * @return
     */
    public List<TaskDataEntity> shuiZhunCeZhan(List<TaskDataEntity> taskDataEntities){
        taskDataEntities.forEach(entity->
        {
            //每一测站数据处理逻辑
            entity.setPostDistance(entity.getPostDistanceUp().subtract(entity.getPostDistanceBottm()));
            entity.setPreDistance(entity.getPreDistanceUo().subtract(entity.getPreDistanceBottm()));
            entity.setDistanceReduce(entity.getPostDistance().subtract(entity.getPreDistance()));

            //黑面差值
            BigDecimal value16 = entity.getPostBlack().subtract(entity.getPreBlack());
            //红面差值
            BigDecimal value17 = entity.getPostRed().subtract(entity.getPreRed());

            BigDecimal value10=entity.getPostBlack().add(new BigDecimal(SysConstants.KValue.k1)).subtract(entity.getPostRed());
            BigDecimal value9=entity.getPreBlack().add(new BigDecimal(SysConstants.KValue.k1)).subtract(entity.getPreRed());

            BigDecimal value11=value10.subtract(value9);

            //待开发

        });
        return taskDataEntities;
    }
}
