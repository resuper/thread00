package com.resuper.bthreadstatus;

public class MyJoin extends Thread{


    public static void main(String[] args) throws InterruptedException {
        // 新生
        MyJoin myBlock = new MyJoin();
        // 就绪
        myBlock.start();
        // cpu 调度到之后进入运行状态

        for (int i = 0; i < 1000; i++) {
            if (i == 10){
                // 将线程实例加入当前线程中，使得当前线程进入阻塞状态，必须等待该线程实例执行结束才能继续，在此场景中当前线程就是main线程
                myBlock.join();
            }
            System.out.println("main 线程====>" + i);
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join 线程====>" + i);
        }
    }
}
