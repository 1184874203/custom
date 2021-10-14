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
    public Object sendMsg(String openId,String templateId,String exUrl) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={accessToken}";
        String accessToken = (String) redisTemplate.opsForValue().get("access_token");
        if (accessToken == null) {
            accessToken = getAccessToken();
        }
        // String openId = "oT9Cm5s0usBrsa_aTzBMnUX7YotM";//syh
        // String openId = "oT9Cm5jzSkHErJHlK2a7L_jgWAUc";
        // String openId = "oT9Cm5icli__LZLy24tf9lJSY0hs";//xin
        // for (int i = 0; i < 3; i++) {
        //
        // }
        MessageReq build = MessageReq.builder()
                .touser(openId)
                // .template_id("vZVQ2kYXI0Ov8kvk3Ea2vpPcBBmfqhj0TtqmPepCWTU")
                .template_id(templateId)
                .url(exUrl)
                .data(MessageData.builder()
                        .first(new MessageValueAndColor("亲爱的Xin~!", "#FF0000"))
                        .keyword1(new MessageValueAndColor("英短还是矮脚？", "#000000"))
                        .keyword2(new MessageValueAndColor("弟弟还是妹妹？", "#000000"))
                        .keyword3(new MessageValueAndColor("哈哈实在是没啥问的。。上面两个问题也问过你了。。", "#000000"))
                        .remark(new MessageValueAndColor("谢谢参与！", "#173177"))
                        .build())
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MessageReq> httpEntity = new HttpEntity<>(build, headers);
        return restTemplate.postForObject(url, httpEntity, Object.class, accessToken);
    }
}
