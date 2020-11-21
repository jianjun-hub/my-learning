package com.jianjun.sm.entity;

import lombok.*;

/**
 * @ClassName Department
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Integer id;
    private  String departmentName;
    private String logo;

     @Override
     public String toString(){
        return departmentName;
    }
}
