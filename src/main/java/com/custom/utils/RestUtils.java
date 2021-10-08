package com.custom.utils;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邵禹寒
 * @date: 2021-09-14 14:15
 */
@Component
public class RestUtils {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyUrl myUrl;

    @Resource
    private Logger log;

    @Bean
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public ResponseEntity<?> getWithParams(String urlType, String urlOperate, Object o, Class<?> resultClazz) throws IllegalAccessException {
        String url = myUrl.getUrl() + myUrl.getMethods().get(urlOperate);
        Class<?> clazz = o.getClass();
        Map<String, Object> params = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            /**
             * f.getName()能拿到所有字段，f.get(o)能拿到对应字段的值
             */
            url += "/{" + f.getName() + "}";
            params.put(f.getName(), f.get(o));
        }
        log.info(url);
        return restTemplate.getForEntity(url, resultClazz, params);
    }
}
