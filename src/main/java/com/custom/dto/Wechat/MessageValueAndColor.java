package com.custom.dto.Wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * message信息 value color
 * @author: 邵禹寒
 * @date: 2021-09-30 17:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MessageValueAndColor {
    private String value;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;
}
