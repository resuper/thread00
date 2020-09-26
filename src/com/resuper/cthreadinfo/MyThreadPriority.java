package com.resuper.cthreadinfo;

public class MyThreadPriority implements Runnable{
    private boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        MyThreadPriority myThreadPropety1 = new MyThreadPriority();
        MyThreadPriority myThreadPropety2 = new MyThreadPriority();
        Thread proxy1 = new Thread(myThreadPropety1,"挨踢1");
        Thread proxy2 = new Thread(myThreadPropety2,"挨踢2");

        // 设置优先级，不代表执行顺序，代表的是概率，不是绝对的优先级，没有绝对的先后顺序
        proxy1.setPriority(Thread.MIN_PRIORITY);
        proxy2.setPriority(Thread.MAX_PRIORITY);

        proxy1.start();
        proxy2.start();

        Thread.sleep(3000);

        myThreadPropety1.stop();
        myThreadPropety2.stop();



    }

    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "====>" + i++);
        }
    }
}
