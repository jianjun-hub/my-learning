package com.jianjun.study.week10;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.Callable;

/**
 * @ClassName SellTicket2
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class SellTicket2 implements Callable<String> {

    private int num = 10;
    private Object o = new Object();

    @Override
    public String call() {
        while (true) {
            synchronized (o){
                    if (num > 0) {
                        System.out.println(Thread.currentThread().getName() + " 正在卖票 " + " 当前票号："+num);
                        num--;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        return "票卖完了";
                    }

            }

        }
    }
}