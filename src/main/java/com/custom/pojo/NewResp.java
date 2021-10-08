package com.custom.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 源数据返回的新闻实体
 *
 * @author: 邵禹寒
 * @date: 2021-09-17 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewResp {
    private int clientId;
    /**
     * 标题
     */
    private String title;
    /**
     * 正文
     */
    private String content;
    private String url;
    private String summary;
    private String filter;
    private String infoType;
    private String shareCode;
    private String newsId;
    private String localt;
    private String channel;
}
