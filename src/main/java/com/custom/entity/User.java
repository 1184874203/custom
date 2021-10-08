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
 * (User)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-30 10:03:32
 */
public class User {
    
    private Integer id;
    
    private String name;
    
    private String pushTime;


}