package com.custom.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.custom.constants.Nlp;
import com.custom.dto.NLP.HttpNlpResp;
import com.custom.dto.NLP.NlpResp;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 邵禹寒
 * @date: 2021-09-07 18:07
 */
@Component
public class GetWords {
    @Resource
    private CloseableHttpClient httpClient;
    @Resource
    private HttpPost httpPost;

    public List<NlpResp> getWords(String text) {
        httpPost.setHeader("token", Nlp.token);
        httpPost.setURI(URI.create(Nlp.url));
        try {
            //模拟form-data
            List<NameValuePair> formData = new ArrayList<>();
            formData.add(new BasicNameValuePair("text", text));
            httpPost.setEntity(new UrlEncodedFormEntity(formData, "utf-8"));
            CloseableHttpResponse response = null;
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            String reString = EntityUtils.toString(responseEntity);

            HttpNlpResp httpNlpResp = JSON.parseObject(reString, HttpNlpResp.class);
            JSONArray jsonArray = JSON.parseArray(httpNlpResp.getData());
            return jsonArray.stream()
                    .map(o -> JSON.parseObject(o.toString(), NlpResp.class))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
