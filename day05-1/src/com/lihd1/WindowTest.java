package com.lihd1;

/**
 * 多线程处理共享数据可能出现问题
 * 1 比如售票 中的错票和重票
 * 2 比如生产者问题和消费者问题
 *
 * 解决方法 利用同步机制，解决线程安全问题
 * 在jdk1.0中有两种方法
 *
 *
 * 1 同步代码块
 * synchronized(同步监视器){
 *      //操作同步数据的代码，不能多也不能少
 * }
 * 同步数据 ： 即多个线程共享的数据
 * 同步监视器 ：又称为锁，可以是任何一个类的对象，要求：锁是唯一的，即多个线程同时使用一把锁才能保证锁的有效性
 * 同步监视器 ：在继承Thread的方式实现多线程时，可以考虑使用 类名.class充当同步监视器
 *            在实现Runnable接口的方式实现多线程时，可以考虑使用 this充当同步监视器
 *
 *
 * 2 同步方法
 *
 *
 *
 * 两种方式实现多线程时需要注意：需要同步的代码不能多也不能少
 * 多了可能是单线程
 * 少了可能没同步
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 16:14
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }

}


class Window implements Runnable{
    private int ticket = 100;
    //可以充当锁，不过写的太麻烦不如写成this
    private Object object = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "售出了 : 第" + ticket-- + "票");
                }else {
                    break;
                }
            }
        }
    }
}
