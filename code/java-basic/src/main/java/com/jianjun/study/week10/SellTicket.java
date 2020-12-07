package com.jianjun.study.week10;

/**
 * @ClassName SellTicket
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class SellTicket extends Thread{
        private int num = 10;

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                while (true){

                    if(num>0){
                        System.out.println(Thread.currentThread().getName()+" 正在卖票 "+" 票数剩余："+num);
                        num--;
                    }else {
                        System.out.println("票卖完了，结束！");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

