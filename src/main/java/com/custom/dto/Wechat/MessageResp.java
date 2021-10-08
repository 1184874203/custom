package com.custom.dto.Wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 17:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MessageResp {
    private Integer errcode;
    private String errmsg;
    private Integer msgid;
}
