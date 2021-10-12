package com.custom.controller;

import com.alibaba.fastjson.JSONObject;
import com.custom.utils.SendMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: 邵禹寒
 * @date: 2021-10-12 10:50
 */
@RestController
@RequestMapping("Wechat")
public class WechatController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private SendMessage sendMessage;

    @GetMapping("accessToken")
    public String getAccessToken() {
        return sendMessage.getAccessToken();
    }

    @GetMapping("templateList")
    public Object getTemplates() {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token={accessToken}";
        String accessToken = (String) redisTemplate.opsForValue().get("access_token");
        if (accessToken == null) {
            accessToken = getAccessToken();
        }
        Object forObject = restTemplate.getForObject(url, Object.class, accessToken);
        return forObject;
    }

    @GetMapping("openId")
    public Object getOpenId() {
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token={accessToken}";
        String accessToken = (String) redisTemplate.opsForValue().get("access_token");
        if (accessToken == null) {
            accessToken = getAccessToken();
        }
        String forObject = restTemplate.getForObject(url, String.class, accessToken);
        return JSONObject.parseObject(forObject);
    }

    @GetMapping("sendMessage")
    public void sendSms() {
        // FIXME: 可以捕获异常
        sendMessage.sendMsg();
    }
}
