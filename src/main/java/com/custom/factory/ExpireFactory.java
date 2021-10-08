package com.custom.factory;

import com.custom.enums.ExpireType;

import java.time.Duration;

/**
 * @author: 邵禹寒
 * @date: 2021-09-27 10:19
 */
public class ExpireFactory {


    public Duration genDuration(ExpireType type, Integer time) {
        switch (type.type) {
            case "minute":
                return Duration.ofMinutes(time);
            default:
                return null;
        }
    }
}
