package com.lihd;

/**
 * start() : 开启一个线程，执行run()方法
 * run() : 将多线程要执行内容放入其中
 * setName() : 设置线程的名字 （开始之前） 也可以使用构造器改变名字
 * getName() : 获取线程的名字
 * currentThread() : 静态方法，获取执行的线程对象
 *
 * yield() : 静态方法 在那个线程中使用就释放那个cpu执行权
 * join() : 在线程a中调用b.join(),b线程执行完成之后 a线程才会结束阻塞状态
 * stop() : 过时，强制结束当前线程 不建议使用
 * sleep(long millitime) : 当前线程休眠指定的毫秒数，休眠时是阻塞状态
 * isAlive() : 判断当前线程是否是阻塞状态
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 8:50
 */
public class ThreadMethodTest {

    public static void main(String[] args) {
        MThread m = new MThread("helloWorld!");//通过构造器 为 m线程取名字
        m.start();
        System.out.println(m.isAlive());

        Thread.currentThread().setName("主函数 ：");
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " : " +i);
            if(i % 10 == 0){
                //释放cpu执行权
                Thread.yield();
            }

            if(i == 25){
                //阻塞主线程，使m线程先执行完毕
                try {
                    m.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(i == 45){
                //强制停止一个线程 已过时 不建议使用
                Thread.currentThread().stop();
            }
        }


        System.out.println(m.isAlive());
    }
}



class MThread extends Thread{

    public MThread(String s){
        super(s);
    }


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            //下面两种方式 在main中调用run()方法时表现不同
            //System.out.println(getName() + " : " +i);


            //每次执行休眠 10ms 这异常只能通过try-catch处理
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            System.out.println(Thread.currentThread().getName() + " : " +i);
        }
    }



}