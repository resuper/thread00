package com.resuper.bthreadstatus;

public class Stop {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        new Thread(thread1).start();

        // 主线程干涉
        for (int i = 0; i < 1000; i++) {
            if (i == 500){
                thread1.myStopThread();
            }
            System.out.println("main 线程====>" + i);
        }
    }
}

class Thread1 implements Runnable{

    private  boolean flag = true;
    @Override
    public void run() {

        while (flag){
            System.out.println("学习 线程...");
        }
    }

    public void myStopThread(){
        this.flag = false;
    }
}
