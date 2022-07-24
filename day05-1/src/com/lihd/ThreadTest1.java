package com.lihd;

/**
 * 线程创建方式二 ： 实现Runnable接口
 *
 * 1 实现Runnable接口
 * 2 实现run方法
 * 3 创建对象
 * 4 将对象作为参数传入Thread(Runnable target)类
 * 5 Thread类对象执行start()方法
 *
 *
 * 两种实现多线程方式的异同
 *
 * 异 ：实现接口的方法打破了类的单继承性，更有助与多线程保持原有的体系 （比如窗口类的父类不应该是线程）
 *     实现接口的方式天然有数据共享的优势
 *     开发中如果要在两种方式中选择，建议使用实现接口的方法
 * 通 ：Thread也实现了Runnable接口，两种方式都需要重写run方法
 * public
 * class Thread implements Runnable {
 *
 *
 *
 * ！：为什么Thread会执行传入参数的run方法呢
 * Thread类中run()方法的声明
 * target是 实现Runnable接口的对象 比较巧妙
 *
 * public void run() {
 *         if (target != null) {
 *             target.run();
 *         }
 * }
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 9:45
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        //3 创建对象
        InterThread interThread = new InterThread();

        //4 作为参数传入 Thread
        Thread t = new Thread(interThread);
        t.setName("接口");
        //5 Thread对象 执行start方法
        t.start();

        //匿名对象
        new Thread(interThread).start();

        Thread.currentThread().setName("主函数");
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }


    }


}
//1 实现Runnable接口的类
class InterThread implements Runnable{
    //2 实现run方法
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
