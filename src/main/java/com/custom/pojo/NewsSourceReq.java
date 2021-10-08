package com.custom.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 邵禹寒
 * @date: 2021-09-17 11:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsSourceReq {

    private Integer clientId;
    private String securityType;
    private String securityCode;
    private String newsType;
    /**
     * 当前页码，默认为0
     */
    private int pageNum = 0;
    /**
     * 页码大小默认为10
     */
    private int pageSize = 10;
}
