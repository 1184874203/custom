package com.custom.dto.Wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MessageReq {
    /**
     * openId
     */
    @Required
    private String touser;
    /**
     * 模板id
     */
    @Required
    private String template_id;
    /**
     * 模板跳转链接
     */
    private String url;
    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private MiniProgram miniprogram;
    /**
     * 模板数据
     */
    @Required
    private MessageData data;
}
