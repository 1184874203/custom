package com.custom.annotation;

import com.custom.enums.ExpireType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 邵禹寒
 * @date: 2021-09-27 10:06
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SetRedis {
    String key() default "";

    String value() default "";

    ExpireType expireType();

    int expireTime();
}
