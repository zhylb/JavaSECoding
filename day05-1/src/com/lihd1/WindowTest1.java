package com.lihd1;

/**
 * 继承方式 synchronized代码块 实现同步
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 16:55
 */
public class WindowTest1 {
    public static void main(String[] args) {
        new Window1().start();
        new Window1().start();
        new Window1().start();
    }
}
class Window1 extends Thread{
    private static int ticket = 100;
    //可以充当锁，不过太麻烦，每次都要写，不如写成 Window1.class
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            //这里不能使用this，主要是因为this不是唯一的，
            //而Class对象Window1.class是一个类对象，类只会加载一次，因此这是正确的
            synchronized (Window1.class){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "售出了 : 第" + ticket-- + "票");
                }else {
                    break;
                }
            }
        }

    }
}