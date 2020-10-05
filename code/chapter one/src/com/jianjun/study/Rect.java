package com.jianjun.study;

public class Rect {
    double width;
    double height;

    double getArea(){
        return width*height;
    }
}

class Example_2{
    public static void main(String[] args) {
        Rect rect = new Rect();
        rect.width = 1.819;
        rect.height = 1.5;
        double area = rect.getArea();
        System.out.println("矩形的面积：" + area);
    }
}
