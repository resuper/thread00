package com.resuper.cthreadinfo;

public class MyThreaInfo implements Runnable {
    private boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        MyThreaInfo myThreaInfo = new MyThreaInfo();
        Thread proxy = new Thread(myThreaInfo);

        proxy.setName("挨踢");

        System.out.println("我的线程名字====>" + proxy.getName());
        System.out.println("当前线程名字====>" + Thread.currentThread().getName());


        System.out.println("线程启动前的状态====>" + proxy.isAlive());
        proxy.start();
        System.out.println("线程启动后的状态====>" + proxy.isAlive());

        // 断点位置，让主线程挂起，我的线程一直在跑，
        // idea需要设置，因为IDEA在Debug时默认阻塞级别是ALL，
        // 方法：View Breakpoints里选择Thread，如下图，然后点击Make Default设置为默认选项
        Thread.sleep(200);


        myThreaInfo.stop();
        Thread.sleep(100);
        System.out.println("线程停止后的状态====>" + proxy.isAlive());
    }

    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("join 线程====>" + i++);
        }
    }
}
