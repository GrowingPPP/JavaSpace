package com.example.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.max-idle}")
    private int maxidle;

    @Value("${spring.redis.min-idle}")
    private int minidle;

    @Value("${spring.redis.max-active}")
    private int maxActive;

    @Value("${spring.redis.max-wait}")
    private long maxWait;
}
