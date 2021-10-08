package com.custom.dto.Wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 17:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MessageData {
    private MessageValueAndColor first;
    private MessageValueAndColor keyword1;
    private MessageValueAndColor keyword2;
    private MessageValueAndColor keyword3;
    private MessageValueAndColor remark;
}
