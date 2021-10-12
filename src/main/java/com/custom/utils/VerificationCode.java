package com.custom.utils;

import com.custom.constants.Verification;
import com.custom.dto.Verification.VerificationReq;
import com.custom.dto.Verification.VerificationResp;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * 验证码登录
 *
 * @author: 邵禹寒
 * @date: 2021-10-11 10:03
 */
public class VerificationCode {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        RedisTemplate redisTemplate = new RedisTemplate();
        String random = MyRandom.getRandom(6);
        String timeStamp = System.currentTimeMillis() + "";
        VerificationReq verificationReq = VerificationReq.builder()
                .accountSid(Verification.ACCOUNT_SID)
                .smsContent("你好！你的验证码为:" + random)
                .to("18001626769")
                .timestamp(timeStamp)
                .sig(DigestUtils.md5Hex(Verification.ACCOUNT_SID + Verification.AUTH_TOKEN + timeStamp))
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<VerificationReq> httpEntity = new HttpEntity<>(verificationReq, headers);
        VerificationResp verificationResp = restTemplate.postForObject(Verification.API_URL, httpEntity, VerificationResp.class);
        System.out.println(verificationResp);
        System.out.println(random);
    }
}
