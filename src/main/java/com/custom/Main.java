package com.custom;

import com.alibaba.fastjson.JSONObject;
import com.custom.constants.WeChat;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邵禹寒
 * @date: 2021-10-11 11:13
 */
public class Main {


    public static void main(String[] args) {
        RedisTemplate redisTemplate = new RedisTemplate();
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> map = new HashMap<>();
        map.put("grant_type", WeChat.GRANT_TYPE);
        map.put("appid", WeChat.APP_ID);
        map.put("secret", WeChat.APP_SECRET);
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type={grant_type}&appid={appid}&secret={secret}";
        String forObject = restTemplate.getForObject(url, String.class, map);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        String accessToken = jsonObject.getString("access_token");
        System.out.println(accessToken);
    }
}
