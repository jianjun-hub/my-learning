package com.jianjun.study.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String id;
    String  name;
    String gender;
    Phone phone;
    Book[] books;
}
