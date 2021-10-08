package com.custom.dto.Wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 17:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MiniProgram {
    /**
     * 所需跳转到的小程序appid
     */
    @Required
    private String appid;

    /**
     * 所需跳转到小程序的具体页面路径
     */
    private String pagepath;
}
