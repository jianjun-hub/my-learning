package com.jianjun.study.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Group
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    String groupName;
    Student[] students;
}
