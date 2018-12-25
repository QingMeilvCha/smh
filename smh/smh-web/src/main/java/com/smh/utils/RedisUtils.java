package com.smh.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/12/24.
 */
@Component
public class RedisUtils {

    @Resource(name = "redisTemplate01")
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key,Object value){
        try{
        redisTemplate.opsForValue().set(key,value);
        return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time 要大于0，如果time小于等于0将设置无限期
     * @return true成功 false失败
     */
    public boolean set(String key,Object value,long time){
        try{
            if(time>0){
            redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
            }else{
                set(key,value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key删除value
     * @param key
     */
    public void romoveValue(String key){
        redisTemplate.delete(key);
    }

    /**
     * 获取单个键值对
     * @param key
     * @return
     */
    public Object hget(String key,String item){
        return key==null?null:redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 获取整个map
     * @param key
     * @return
     */
    public Map<Object,Object> hmget(String key){
        return key==null?null:redisTemplate.opsForHash().entries(key);
    }

    /**
     * 设置map
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置map并设置时间
     * @param key
     * @param map
     * @param time 单位秒
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            hmset(key,map);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置map单个entry
     * @param key
     * @param item
     * @param o
     * @return
     */
    public boolean hset(String key, String item,Object o) {
        try {
            redisTemplate.opsForHash().put(key, item,o);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置map单个entry并设置时间
     * @param key
     * @param item
     * @param o
     * @param time
     * @return
     */
    public boolean hset(String key,String item,Object o, long time) {
        try {
            hset(key,item,o);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
