package com.jianjun.study.week5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Book
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/2
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String isbn;
    private String bookName;
    private  Double price;
}
