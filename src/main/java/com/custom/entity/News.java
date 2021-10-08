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
 * (News)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-16 15:20:35
 */
public class News {

    public Integer id;

    public String title;

    public String head;

    public String body;


}