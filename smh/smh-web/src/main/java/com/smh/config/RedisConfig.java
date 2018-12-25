package com.smh.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;

/**
 * Created by zhouyuhang on 2018/12/24.
 */
@Configuration
@ConditionalOnProperty(value = "spring.redis.enabled",havingValue = "true",matchIfMissing = true)
public class RedisConfig {

    @Bean(name = "redisTemplate01")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<?> defaultSerializer = new StringRedisSerializer();
        template.setDefaultSerializer(defaultSerializer); //默认的序列化方式

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        valueSerializer.setObjectMapper(objectMapper);
        template.setValueSerializer(valueSerializer); //value的序列化方式
        template.setHashValueSerializer(valueSerializer); //hash value的序列化方式
        template.afterPropertiesSet();
        return template;
    }
}
