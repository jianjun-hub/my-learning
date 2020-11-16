package com.jianjun.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    private  Integer id;
    private String account;
    private String password;
    private String adminName;
}
