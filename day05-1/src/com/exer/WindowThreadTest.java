package com.exer;

/**
 * 方式一 多线程实现 多窗口买票 存在线程安全问题
 * 注意点 ： 继承方式的多线程共享数据一定要设计为 static,否则每人一份数据，达不到效果
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 9:21
 */
public class WindowThreadTest {

    public static void main(String[] args) {
        WindowThread t1 = new WindowThread();
        WindowThread t2 = new WindowThread();
        WindowThread t3 = new WindowThread();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowThread extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(getName() + " : 卖出了第 " + ticket-- + " 章票");
            }else{
                break;
            }
        }
    }
}
