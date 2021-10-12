package com.custom.utils;

import com.alibaba.fastjson.JSONObject;
import com.custom.constants.WeChat;
import com.custom.dto.Wechat.MessageData;
import com.custom.dto.Wechat.MessageReq;
import com.custom.dto.Wechat.MessageValueAndColor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 16:14
 */
@Component
public class SendMessage {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获取token，存入redis，时效2小时
     *
     * @return
     */
    public String getAccessToken() {
        String accessToken = (String) redisTemplate.opsForValue().get("access_token");
        if (accessToken != null) {
            return accessToken;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("grant_type", WeChat.GRANT_TYPE);
        map.put("appid", WeChat.APP_ID);
        map.put("secret", WeChat.APP_SECRET);
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type={grant_type}&appid={appid}&secret={secret}";
        String forObject = restTemplate.getForObject(url, String.class, map);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        accessToken = jsonObject.getString("access_token");
        redisTemplate.opsForValue().set("access_token", accessToken, Duration.ofHours(2L));
        return accessToken;
    }

    /**
     * 推送消息的工具类
     */
    public void sendMsg() {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={accessToken}";
        String accessToken = (String) redisTemplate.opsForValue().get("access_token");
        if (accessToken == null) {
            accessToken = getAccessToken();
        }
        String openId = "oT9Cm5s0usBrsa_aTzBMnUX7YotM";
        // String openId = "oT9Cm5jzSkHErJHlK2a7L_jgWAUc";
        for (int i = 0; i < 3; i++) {
            MessageReq build = MessageReq.builder()
                    .touser(openId)
                    .template_id("vZVQ2kYXI0Ov8kvk3Ea2vpPcBBmfqhj0TtqmPepCWTU")
                    .url("https://www.baidu.com")
                    .data(MessageData.builder()
                            .first(new MessageValueAndColor("标题", "#173177"))
                            .keyword1(new MessageValueAndColor("第" + i + "条", "#000000"))
                            .keyword2(new MessageValueAndColor("我们从不证实那个问题，那一些是非题，总让人伤透脑筋；在你眼里我是什么关系", "#000000"))
                            .keyword3(new MessageValueAndColor("全创", "#000000"))
                            .remark(new MessageValueAndColor("再次提醒！", "#173177"))
                            .build())
                    .build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<MessageReq> httpEntity = new HttpEntity<>(build, headers);
            restTemplate.postForObject(url, httpEntity, Object.class, accessToken);
        }
    }
}
