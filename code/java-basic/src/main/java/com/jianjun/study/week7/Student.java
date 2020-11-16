package com.jianjun.study.week7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    @Override
    public int compareTo(Student o) {
        return this.getAge().compareTo(o.getAge());
    }
}
