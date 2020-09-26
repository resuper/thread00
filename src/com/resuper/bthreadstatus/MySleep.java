package com.resuper.bthreadstatus;

public class MySleep extends Thread {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("main线程 ===>10s内每秒打印一个数：" + i);

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("其他 线程====>" + i);
        }
    }
}
