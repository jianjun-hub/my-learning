package com.jianjun.study.week3;

/**
 * @ClassName OverLoadTestApp
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
public class OverLoadTestApp {
    public static void main(String[] args) {
        OverLoadTest olt  = new OverLoadTest();
        System.out.println(olt.sumS(60,60));
        System.out.println(olt.sumS(3600,3600));
        System.out.println(olt.sumS(3600,3660));
        System.out.println(olt.sumS(3600,3678));
        System.out.println(olt.sumS(86400,3660));
        System.out.println(olt.sumS(604800,3678));
        System.out.println(olt.sumS(-100,20));
        System.out.println(olt.sum(86400,3660));
        System.out.println(olt.sum("中国","历史"));
    }
}
