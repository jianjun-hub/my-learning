package com.jianjun.study.week5;

import lombok.Data;

/**
 * @ClassName IsbnException
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/2
 **/
public class BookIsbnException extends Exception {
    private  String message;


    public BookIsbnException(String message){
        super(message);
    }
}
