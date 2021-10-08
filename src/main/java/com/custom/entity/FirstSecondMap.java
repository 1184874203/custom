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
 * (FirstSecondMap)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
public class FirstSecondMap {

    private Integer id;

    private Integer firstId;

    private Integer secondId;

    private String createTime;

    private String updateTime;


}