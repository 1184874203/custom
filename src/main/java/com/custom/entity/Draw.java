package com.custom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-10-11 11:07
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Draw {
    private Integer id;
    private String value;
    private Integer ratio;
}
