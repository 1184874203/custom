package com.custom.utils;

import com.custom.dto.Wechat.MessageData;
import com.custom.dto.Wechat.MessageReq;
import com.custom.dto.Wechat.MessageResp;
import com.custom.dto.Wechat.MessageValueAndColor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 16:14
 */
public class SendMessage {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 推送消息的工具类
     */
    public void sendMsg() {
        MessageReq build = MessageReq.builder()
                .touser("OPENID")
                .template_id("template_id")
                .data(MessageData.builder()
                        .first(MessageValueAndColor.builder()
                                .value("恭喜!")
                                .color("#173177").build())
                        .keyword1(MessageValueAndColor.builder()
                                .value("恭喜!")
                                .color("#173177").build())
                        .keyword2(MessageValueAndColor.builder()
                                .value("恭喜!")
                                .color("#173177").build())
                        .keyword3(MessageValueAndColor.builder()
                                .value("恭喜!")
                                .color("#173177").build())
                        .remark(MessageValueAndColor.builder()
                                .value("恭喜!")
                                .color("#173177").build())
                        .build())
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MessageReq> httpEntity = new HttpEntity<>(build, headers);
        String url = "";
        MessageResp messageResp = restTemplate.postForObject(url, httpEntity, MessageResp.class);
    }


    public void sendMessage(String open_id, String access_token, String user_name, String test_time, String bodyCompostionText) {
        try {
            String regUser = "http://wxdemo.xxxx.com/wxdevices/bodycompositionmain?openId=" + open_id;
            String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("touser", open_id); //推送用户openid
            map.put("template_id", "a"); //指定模版ID
            map.put("url", regUser);  //点击模版跳转地址
            Map<String, Object> data_map = new HashMap<String, Object>();
            Map<String, Object> first = new HashMap<String, Object>();
            first.put("value", "您好，你有一条体脂检测信息");
            first.put("color", "#000000");
            Map<String, Object> keynote1 = new HashMap<String, Object>();
            keynote1.put("value", user_name);
            keynote1.put("color", "#000000");
            Map<String, Object> keynote2 = new HashMap<String, Object>();
            keynote2.put("value", test_time);
            keynote2.put("color", "#000000");
            Map<String, Object> keynote3 = new HashMap<String, Object>();
            keynote3.put("value", bodyCompostionText);
            keynote3.put("color", "#000000");
            Map<String, Object> remark = new HashMap<String, Object>();
            remark.put("value", "点击查看详情");
            remark.put("color", "#000000");
            data_map.put("first", first);
            data_map.put("keyword1", keynote1);
            data_map.put("keyword2", keynote2);
            data_map.put("keyword3", keynote3);
            data_map.put("remark", remark);
            map.put("data", data_map);
            // JSONObject json = JSONObject.fromObject(map);
            // String result = HttpUtil.sendPost(url, json.toString());
            // System.out.println(result);
            // JSONObject json_arr = JSONObject.fromObject(result);
            // String isOk = String.valueOf(json_arr.get("errmsg"));
            // logger.info(" errmsg >>>>>>>>> "+isOk);
            // if(isOk.equals("ok")){
            //     logger.info("体脂据推送成功 , "+open_id );
            // }else{
            //     logger.info("体脂据推送失败 , "+open_id );
            // }
        } catch (Exception e) {
            // logger.error("", e);
        }
    }

    public static void main(String[] args) {
        String name = "syh";
        String url = "https://www.baidu.com?name={name}";
        System.out.println(url);
    }
}
