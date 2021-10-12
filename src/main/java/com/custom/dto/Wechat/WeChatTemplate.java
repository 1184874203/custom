package com.custom.dto.Wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-10-12 10:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class WeChatTemplate {
    private String template_id;
    private String title;
    private String primary_industry;
    private String deputy_industry;
    private String content;
    private String example;
}
