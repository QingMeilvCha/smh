package com.smh.config;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * Created by zhouyuhang on 2019/1/9.
 */
public class DemoTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        System.out.println("======================================================"+collection.toString());
        for (String each : collection) {
            if (each.endsWith(preciseShardingValue.getValue() % 2+"")) {
                System.out.println("======================================================"+each);
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
