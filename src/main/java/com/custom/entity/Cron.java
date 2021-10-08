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
 * (Cron)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-29 17:15:08
 */
public class Cron {

    private Integer id;

    private String cron;


}