package com.custom.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author: 邵禹寒
 * @date: 2021-09-13 17:43
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "myurls")
public class MyUrl {
    private String url;
    private Map<String, String> methods;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
}
