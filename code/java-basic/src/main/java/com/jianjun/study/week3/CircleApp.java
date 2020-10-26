package com.jianjun.study.week3;

/**
 * @ClassName CircleApp
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
public class CircleApp {
    public static void main(String[] args) {
        Point point  = new Point(10,20);
        Circle circle = new Circle(10,20,5);
        Cylinder cylinder = new Cylinder(10, 10, 5, 6);
        point.print();
        circle.print();
        cylinder.print();

        //创建两个point对象，求出两点之间的距离

        Point pointA = new Point(20,30);
        Point pointB = new Point(30,50);
        System.out.println(distance(pointA, pointB));

        //创建一个point对象，判断这个point是否在上面的圆内
        Point pointC = new Point(25,35);
        Point pointD = new Point(10,22);
        Point pointE = new Point(10,20);
        System.out.println(isInCircle(pointC, circle));
        System.out.println(isInCircle(pointD, circle));
        System.out.println(isInCircle(pointE, circle));

    }




    private static   double distance(Point point1, Point point2){
        double diffrenceX = point1.getX() - point2.getX();
        double diffrentY = point1.getY() - point2.getY();
        return Math.sqrt (diffrenceX*diffrenceX+diffrentY*diffrentY);
    }

    
    private static String isInCircle(Point point,Circle circle){
        String result = "";
        Point center  = new Point(circle.getX(),circle.getY());
        if(distance(point,center) == 0){
              result = "点在圆心上";
        }else  if(distance(point,center)<=circle.getR()){
            result = "点在圆内";
        }else {
            result = "点不在圆内";
        }
        return result;
    }

}
