package com.jianjun.study.week10;

/**
 * @ClassName SellTicket1
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/

public class SellTicket1 implements Runnable {
    private int num = 10;
    private Object o = new Object();
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (o){
                    if (num > 0) {
                        System.out.println(Thread.currentThread().getName() + " 正在卖票 " + " 当前票号："+num+" 票数剩余：" + (num-1));
                        num--;
                    } else {
                        System.out.println(Thread.currentThread().getName()+" 票卖完了，结束！");
                        System.exit(0);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}