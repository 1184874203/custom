package com.custom.dto.NLP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-09-07 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class HttpNlpResp {
    private int code;
    private String data;
}
