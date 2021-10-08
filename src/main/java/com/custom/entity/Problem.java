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
 * (Problem)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
public class Problem {
    
    private Integer id;
    
    private String categoryCode;
    
    private String description;
    
    private Integer principalId;


}