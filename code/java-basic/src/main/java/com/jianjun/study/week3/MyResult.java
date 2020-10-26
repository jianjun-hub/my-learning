package com.jianjun.study.week3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Myresult
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyResult {
    private int max;
    private int min;
    private int sum;
}
