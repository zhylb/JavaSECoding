package com.lihd;

/**
 * 线程优先级测试
 *
 * 线程一共有十个优先级 （1 -10），这个数字越大优先级越高
 * 优先级高的线程不一定先执行完毕，只是优先级较高
 *
 * Thread.MAX_PRIORITY 10 最高优先级
 * Thread.NORM_PRIORITY 5 默认优先级
 * Thread.MIN_PRIORITY 1 最低优先级
 *
 * 如果要设置优先级为（1,5,10）最好使用Thread.常量的形式，而不是干巴巴的数字1,5,10
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 9:12
 */
public class PriorityTest {
    public static void main(String[] args) {
        PThread p = new PThread();
        p.setName("Lover");
        System.out.println(p.getPriority());

        p.setPriority(Thread.MAX_PRIORITY);//设置最高优先级
        p.start();

        Thread.currentThread().setName("Never");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY); //给主线程设置最低优先级
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }



    }


}


class PThread extends MyThread{


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " : " + i);
        }
    }
}
