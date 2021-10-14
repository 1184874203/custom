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
 * (Tryxx)实体类
 *
 * @author 邵禹寒
 * @since 2021-10-13 18:16:57
 */
public class Tryxx {
    
    private Integer id;
    
    private String ryxm;
    
    private String zjbh;
    
    private String rybh;
    
    private String rhrq;
    
    private String lzrq;
    
    private String zhzt;


}