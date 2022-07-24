package com.lihd2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三 ：lock锁 --JDK5新增
 * Lock 是一个接口，常用实现类 ReentrantLock 可重入锁
 * 使用步骤
 * 1 创建ReentrantLock对象
 * 2 使用try包裹同步代码，不写catch，finally无内容
 * 3 try中第一行，lock.lock(),finally中lock.unlock()即可
 * 4 补充 构造器介绍 ，有两种 （void,和 boolean）,这个布尔值代表的是公平的意思，一般设置为false,
 *      设置为true，线程会按顺序有规律的执行，默认值false *
 *
 * 问题 synchronized 和 lock的异同
 * 同 ： 都可以解决线程同步问题
 * 异 ： synchronized在执行完相关代码后，自动释放锁;
 *      lock需要手动开始lock(),也需要手动结束unlock();
 *
 * 底层原理：
 * 当我们new一个ReentrantLock对象时，底层会帮我们new一个NonfairSync对象，NonfairSync FairSync都是基于
 * AQS队列实现，AbstractQueuedSynchronizer简称为AQS队列。它是基于先进先出FIFO实现的等待队列，AQS队列
 * 是由Node节点组成的双向连标实现啊的，所有的操作都是在这个AQS队列当中，如果一个线程获取锁就直接成功，如果失败了
 * 就将其放入等待队列当中。
 *
 * 以后开发中建议使用 lock()
 *
 *
 *
 * 银行存款，三个人，每个人一次存1000，每个人存三次，初始金额0
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 20:38
 */
public class LockTest {
    public static void main(String[] args) {
        Bank b = new Bank();
        new Thread(b).start();
        new Thread(b).start();
        new Thread(b).start();
    }
}

class Bank implements Runnable{

    private int balance;
    //ReentrantLock lock = new ReentrantLock(false);
    ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try{
                lock.lock();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(Thread.currentThread().getName() + " 存款前 " + balance);
                balance += 1000;
                System.out.println(Thread.currentThread().getName() + " 存款后 " + balance);
            }finally {
                lock.unlock();
            }
        }
    }
}
