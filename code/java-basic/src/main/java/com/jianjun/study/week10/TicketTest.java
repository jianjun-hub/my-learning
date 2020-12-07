package com.jianjun.study.week10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName TicketTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class TicketTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        SellTicket sellTicket =new SellTicket();
//        sellTicket.setName("窗口1");
//        sellTicket.start();
//        SellTicket sellTicket1=new SellTicket();
//        sellTicket1.setName("窗口2");
//        sellTicket1.start();
//        SellTicket sellTicket2 =new SellTicket();
//        sellTicket2.setName("窗口3");
//        sellTicket2.start();
//        SellTicket1 sellTicket1 = new SellTicket1();
//        Thread thread = new Thread(sellTicket1);
//        thread.setName("窗口1");
//        thread.start();
//
//        Thread thread1 = new Thread(sellTicket1);
//        thread1.setName("窗口2");
//        thread1.start();
//
//        Thread thread2 = new Thread(sellTicket1);
//        thread2.setName("窗口3");
//        thread2.start();
        SellTicket2 sellTicket2 = new SellTicket2();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(sellTicket2);
        Future<String> future = pool.submit(sellTicket2);
        pool.shutdown();
        System.out.println(future.get());
    }
}


