package com.resuper.bthreadstatus;

public class MyYield extends Thread {
    public static void main(String[] args) throws InterruptedException {
        // 新生
        MyYield myYield = new MyYield();
        // 就绪
        myYield.start();
        // cpu 调度到之后进入运行状态

        for (int i = 0; i < 1000; i++) {
            if (i % 20 == 0){
                // 写在什么线程体中就暂停哪个线程，这里暂停的是main线程
                Thread.yield();
            }
            System.out.println("main 线程====>" + i);
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("其他 线程====>" + i);
        }
    }
}
