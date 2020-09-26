package com.resuper.synchronizedkey;

public class MySleepNetWork implements Runnable {

    private int num = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
//            test1();
//            test2();
//            test3();
//            test4();
//            test5();
            test6();
        }
    }

    // 线程不安全 未加 synchronized
    public void test1() {
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");
    }

    // 方法级别 线程安全
    public synchronized void test2() {
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");
    }



    // 同步块 线程安全
    public void test3() {
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");

        }
    }

    // 没有锁定正确，线程不安全，a运行到try语句时，b已经进入  synchronized 块
    public void test4() {
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");

    }

    // 锁定操作的资源，但未锁定其他信息，线程不安全
    public void test5() {
        synchronized ((Integer) num) {
            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");
        }

    }

    // 线程不安全，锁定范围小
    public void test6() {
        if (num <= 0) {
            flag = false;
            return;
        }
        synchronized (this){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");
        }


    }


    public static void main(String[] args) {

        MySleepNetWork web12306 = new MySleepNetWork();

        new Thread(web12306, "路人甲").start();
        new Thread(web12306, "路人乙").start();
        new Thread(web12306, "路人丙").start();
    }
}
