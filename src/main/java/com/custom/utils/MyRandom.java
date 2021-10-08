package com.custom.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author: 邵禹寒
 * @date: 2021-09-07 11:40
 */
public class MyRandom {
    public static String getRandom(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; ++i) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
}
