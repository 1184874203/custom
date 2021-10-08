package com.custom.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author: 邵禹寒
 * @date: 2021-09-24 10:32
 */
@SpringBootTest
public class MyRandomTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        System.out.println(redisTemplate.opsForValue().get("a"));
    }

}