package com.custom.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 源数据的最基本返回体
 * {
 * code:200,
 * msg:"",
 * data{}
 * }
 *
 * @author: 邵禹寒
 * @date: 2021-09-17 11:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsBasicResp {
    private String code;
    private String msg;
    private NewsSourceResp data;
}
