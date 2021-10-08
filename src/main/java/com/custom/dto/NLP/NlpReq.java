package com.custom.dto.NLP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-09-07 17:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class NlpReq {
    private String text;
}
