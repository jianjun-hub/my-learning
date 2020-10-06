package com.jianjun.study.week1;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.Random;

/**
 * @ClassName ArrayTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/5
 **/
public class ArrayTest {
    static int MAX = 6;
    public static void main(String[] args) {
        int[] a = new int[MAX];
        Random random = new Random();
        for (int i = 0; i < MAX; i++) {
            a[i] = random.nextInt(100);
            System.out.println(a[i] + " ");

        }
        //用一次循环求出最大值，最小值，和
        int max = a[0];
        int min = a[0];
        int sum = a[0];
        for (int j = 1; j < a.length; j++) {
            if (a[j] > max) {
                max = a[j];
            } else if (a[j] < min) {
                min = a[j];
            }
            sum = sum + a[j];

        }
        System.out.println("最大值：" + max + " 最小值：" + min + " 和：" + sum);

        //排序
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length - i - 1; k++) {
                if (a[k] > a[k + 1]) {
                    int big = a[k];
                    int small = a[k + 1];
                    a[k] =  small;
                    a[k + 1] = big;
                }
            }

        }
        //打印数组
        printArray(a);
    }

    public static  void printArray(int[] A){
        for (int j : A) {
            System.out.println(j);
        }
    }

}
