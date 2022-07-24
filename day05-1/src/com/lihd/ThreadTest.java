package com.lihd;

/**
 * 创建多线程的方式一 ： 继承于Thread
 * 1 继承于Thread
 * 2 重写Run方法
 * 3 创建子类对象
 * 4 调用start()方法
 *
 * tips
 * 1 把要实现多线程的内容写在run方法中
 * 2 start方法 有两个作用 ：启动线程 执行run方法
 * 3 只执行run方法并不是多线程，只是一个普通的方法
 * 4 start方法会将线程的状态改变（就绪 -》 死亡），因此不能重复执行start方法 IllegalThreadStateException
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/6 9:58
 */
public class ThreadTest {

    public static void main(String[] args) {
        //3 创建对象
        MyThread m = new MyThread();

        //4 执行start方法
        m.start();//新的线程
        // m.start(); 不能重复执行
        m.run();//main方法中的线程

    }
}
//1 继承于MyThread
class MyThread extends Thread{

    //2 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
