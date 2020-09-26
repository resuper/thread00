package com.resuper.bthreadstatus;

public class MySleepNetWork implements  Runnable{

    private int num = 100;

    @Override
    public void run() {
        while (true){
            if(num < 0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"抢到了第" +  num-- + "张票");
        }
    }

    public static void main(String[] args) {
        MySleepNetWork web12306 = new MySleepNetWork();
        new Thread(web12306,"路人甲").start();
        new Thread(web12306,"路人乙").start();
        new Thread(web12306,"路人丙").start();
    }
}
