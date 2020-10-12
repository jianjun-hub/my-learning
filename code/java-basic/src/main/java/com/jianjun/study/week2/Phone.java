package com.jianjun.study.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Phone
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    private String brand;
    private Integer price;
}
