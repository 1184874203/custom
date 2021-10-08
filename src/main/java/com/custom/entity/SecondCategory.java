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
 * (SecondCategory)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
public class SecondCategory {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 类目编码
     */
    private String categoryCode;
    /**
     * 中文描述
     */
    private String description;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;


}