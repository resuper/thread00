package com.resuper.acreatethread;

public class MyThread {
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("一边听歌..." + i);
        }
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("一边写代码..." +i);
        }
    }
}
