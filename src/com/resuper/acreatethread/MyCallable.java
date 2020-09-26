package com.resuper.acreatethread;

import java.util.concurrent.*;

/**
 * 龟兔赛跑，
 * 在2s内，时间可以自定义，乌龟和兔子的速度也需要可以调整
 * 分别返回各自所跑的步数
 */
public class MyCallable implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flag = true;
    private int step = 0;

    public MyCallable(String name,long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while (flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建2个线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyCallable tortoise = new MyCallable("乌龟",1000);
        MyCallable rabbit = new MyCallable("小兔子",500);

        //  启动线程获取值
        Future<Integer> result1 = executorService.submit(tortoise);
        Future<Integer> result2 = executorService.submit(rabbit);

        // 主线程休眠，让乌龟和兔子各自3s
        Thread.sleep(3000);

        // 停止线程
        tortoise.setFlag(false);
        rabbit.setFlag(false);


        Integer number1 = result1.get();
        Integer number2 = result2.get();
        System.out.println("乌龟跑了--->" + number1 + "步");
        System.out.println("兔子跑了--->" + number2 + "步");

        // 停止线程
        executorService.shutdownNow();
    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
