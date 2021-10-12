package com.custom.dto.Verification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

/**
 * @author: 邵禹寒
 * @date: 2021-10-11 10:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VerificationReq {
    private String respDataType;
    @Required
    private String accountSid;

    private String templateid;
    private String smsContent;
    @Required
    private String to;
    @Required
    private String timestamp;
    @Required
    private String sig;
    private String expandId;

    private String param;
    private String subCode;
    private String accountId;
    private String smsType;

}
