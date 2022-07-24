package com.lihd2;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 20:25
 */
public class DeadLockTest {
    public static void main(String[] args) {
        DeadA a = new DeadA();
        DeadB b = new DeadB();
        //使用java1.8新特性 启动两个线程
        new Thread(() -> a.begin(b)).start();
        new Thread(() -> b.begin(a)).start();

    }

}

class DeadA{

    public synchronized void begin(DeadB b){
        System.out.println("DeadA :: begin方法");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.end();
    }

    public synchronized void end(){
        System.out.println("DeadA :: end方法");
    }
}

class DeadB{
    public synchronized void begin(DeadA a) {
        System.out.println("DeadB :: begin方法");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.end();
    }

    public synchronized void end(){
        System.out.println("DeadB :: end方法");
    }
}