package com.custom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: 邵禹寒
 * @date: 2021-09-03 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class SecondCodeDto {
    private String code;
    private String description;
}
