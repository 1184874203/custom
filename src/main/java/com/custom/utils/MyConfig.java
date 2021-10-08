package com.custom.utils;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 邵禹寒
 * @date: 2021-09-06 15:35
 */
@Configuration
public class MyConfig {

    @Bean
    public Logger myLogger() {
        return LoggerFactory.getLogger(Logger.class);
    }

    @Bean
    public CloseableHttpClient httpClient() {
        return HttpClientBuilder.create().build();
    }

    @Bean
    public HttpPost httpPost() {
        return new HttpPost();
    }

    @Bean
    public Logger log() {
        return LoggerFactory.getLogger(Logger.class);
    }


}
