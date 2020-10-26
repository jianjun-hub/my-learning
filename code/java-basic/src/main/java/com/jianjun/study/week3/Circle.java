package com.jianjun.study.week3;

import lombok.Data;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
@Data
public class Circle extends Point {
    private int r;

    public Circle() {
        System.out.println("圆被初始化");
    }

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
        System.out.println("带参数的圆被初始化");
    }

    @Override
    public void print() {
        System.out.println("圆的面积" + Math.PI * r * r);
    }

    public Double getArea() {
        return Math.PI * r * r;
    }
}
