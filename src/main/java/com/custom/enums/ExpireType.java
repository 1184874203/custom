package com.custom.enums;

/**
 * @author: 邵禹寒
 * @date: 2021-09-27 10:13
 */
public enum ExpireType {
    MINUTE("minute");

    public String type;

    ExpireType(String type) {
        this.type = type;
    }
}
