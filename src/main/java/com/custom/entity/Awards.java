package com.custom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
/**
 * (Awards)实体类
 *
 * @author 邵禹寒
 * @since 2021-10-11 13:34:26
 */
public class Awards {

    private Integer id;

    private String value;

    private Integer ratio;


}