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
 * (FirstCategory)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:05
 */
public class FirstCategory {
    
    private Integer id;
    
    private String categoryCode;
    
    private String description;
    
    private String createTime;

    private String updateTime;


}