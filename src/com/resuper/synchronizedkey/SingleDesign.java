package com.resuper.synchronizedkey;

public class SingleDesign {
    public static void main(String[] args) {
        SingleThreadJVMSecurity jvm1 = SingleThreadJVMSecurity.getInstance(2000);
        SingleThreadJVMSecurity jvm2 = SingleThreadJVMSecurity.getInstance(2000);
        System.out.println(jvm1);
        System.out.println(jvm2);

//        MultiThreadJVMUnSecurity jvmThread1 = new MultiThreadJVMUnSecurity(100);
//        MultiThreadJVMUnSecurity jvmThread2 = new MultiThreadJVMUnSecurity(800);
//        jvmThread1.start();
//        jvmThread2.start();

        MultiThreadJVMSecurity jvmThread21 = new MultiThreadJVMSecurity(200);
        MultiThreadJVMSecurity jvmThread22 = new MultiThreadJVMSecurity(800);
        jvmThread21.start();
        jvmThread22.start();
    }


}

/**
 * 懒汉式
 * 1. 构造器私有化
 * 2. 声明一个静态变量
 * 3. 创建一个对外公共的静态方法访问该斌良，如果变量为null则创建，如果有了，则返回该对象
 * 线程不安全
 */
class SingleThreadJVMSecurity{
    // 1. 构造器私有化
    // 2. 声明一个静态变量
    // 3. 创建一个对外公共的静态方法访问该斌良，如果变量为null则创建，如果有了，则返回该对象
    private static SingleThreadJVMSecurity instance = null;
    private SingleThreadJVMSecurity(){

    }

    public static SingleThreadJVMSecurity getInstance(long time) {
        if(instance == null){
            instance = new SingleThreadJVMSecurity();
        }
        return instance;
    }
}









class JVM1{
    // 1. 构造器私有化
    // 2. 声明一个静态变量
    // 3. 创建一个对外公共的静态方法访问该斌良，如果变量为null则创建，如果有了，则返回该对象
    private static JVM1 instance = null;
    private JVM1(){

    }

    public static JVM1 getInstance(long time) {
        if(instance == null){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new JVM1();
        }
        return instance;
    }
}

class MultiThreadJVMUnSecurity extends Thread{
    private long time;
    public MultiThreadJVMUnSecurity(long time){
        this.time = time;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "====>" + JVM1.getInstance(time));
    }
}
















class JVM2{
    // 1. 构造器私有化
    // 2. 声明一个静态变量
    // 3. 创建一个对外公共的静态方法访问该斌良，如果变量为null则创建，如果有了，则返回该对象
    private static JVM2 instance = null;
    private JVM2(){

    }

    public synchronized static JVM2 getInstance(long time) {
        if(instance == null){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new JVM2();
        }
        return instance;
    }
}
class MultiThreadJVMSecurity extends Thread{
    private long time;
    public MultiThreadJVMSecurity(long time){
        this.time = time;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "====>" + JVM2.getInstance(time));
    }
}


