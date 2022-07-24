package com.lihd1;

/**
 * 当需要同步的代码刚好可以在一个方法中，可以使用同步方法
 * 使用实现接口方式 解决线程安全问题
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 17:06
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();
        new Thread(window2).start();
        new Thread(window2).start();
        new Thread(window2).start();
    }

}
class Window2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (sellTicket());
    }
    //同步监视器 this,非static方法默认监视器为this
    private synchronized boolean sellTicket(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "售出了 : 第" + ticket-- + "票");
            return true;
        }
        return false;
    }
}
