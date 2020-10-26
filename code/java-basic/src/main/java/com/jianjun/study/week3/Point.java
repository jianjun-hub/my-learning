package com.jianjun.study.week3;

import lombok.Data;

/**
 * @ClassName Point
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
@Data
public class Point {
    private Integer x;
    private Integer y;
    public  Point(){
        System.out.println("点被初始化");
    }
    public  Point(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("带参数的点被初始化");
    }

    public  void print(){
        System.out.println("横坐标：" + this.x+" 纵坐标：" + this.y);
    }

}
