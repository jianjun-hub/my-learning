package com.jianjun.study.week1;

/**
 * @ClassName Factorial
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/5
 **/
public class Factorial {
    public static void main(String[] args) {
        //定义一个整形变量
        int n = 5 ;

        long result  = 1;

        for(int i = 1; i<= n; i++){
            result *=  i;
        }

        System.out.println(n+"的阶乘是"+result);
    }

}
