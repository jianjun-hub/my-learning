package com.jianjun.study.week3;

/**
 * @ClassName Cylinder
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
public class Cylinder extends Circle {
    private int h;

    public Cylinder(int x, int y, int r, int h) {
        super(x, y, r);
        this.h = h;
    }

    @Override
    public void print() {
        System.out.println("圆柱的体积：" + super.getArea() * h);
    }
}
