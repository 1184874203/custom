package com.custom.dto.Verification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author: 邵禹寒
 * @date: 2021-10-11 10:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VerificationResp {
    private String respCode;
    private String respDesc;
    private String smsId;
    private List<String> failList;
}
