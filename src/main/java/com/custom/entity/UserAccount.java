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
 * (UserAccount)实体类
 *
 * @author 邵禹寒
 * @since 2021-09-24 10:49:17
 */
public class UserAccount {

    private Integer id;

    private String account;

    private String password;


}