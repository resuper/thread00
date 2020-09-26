package com.resuper.acreatethread;

public class MyRunable implements  Runnable{
    private int num = 500;
    @Override
    public void run() {
        while (true){
            if(num < 0){
                break;
            }
            System.out.println(Thread.currentThread().getName() +"抢到了第" +  num--);
        }
    }

    public static void main(String[] args) {
        MyRunable web12306 = new MyRunable();
        new Thread(web12306,"路人甲").start();
        new Thread(web12306,"路人乙").start();
        new Thread(web12306,"路人丙").start();
        new Thread(web12306,"xxx").start();
        new Thread(web12306,"yyy").start();
        new Thread(web12306,"zzz").start();
    }
}
