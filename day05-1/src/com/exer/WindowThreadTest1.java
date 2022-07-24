package com.exer;

/**
 * 方式二实现多线程买票，存在线程安全问题
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 15:06
 */
public class WindowThreadTest1 {
    public static void main(String[] args) {
        WindowThread1 windowThread1 = new WindowThread1();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();
        new Thread(windowThread1).start();

    }

}

class WindowThread1 implements Runnable{
    private int ticket = 100;//没有必要设计为static
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + " : 卖出了第 " + ticket-- + " 章票");
            }else{
                break;
            }
        }
    }
}
