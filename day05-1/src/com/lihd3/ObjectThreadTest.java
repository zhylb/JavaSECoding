package com.lihd3;

/**
 * 介绍Object类中关于线程安全的三个方法
 * 搭配 synchronized使用，
 * 这三个要在同步代码块或同步方法中使用，调用者必须是同步监视器（锁），否则会报错
 * wait() : 同步锁执行此方法后，线程会进入阻塞状态，并释放同步锁，此方法抛异常。
 * notify() : 同步锁执行此方法后，一个被wait()阻塞的线程会被唤醒，如果有多个线程就唤醒优先级高的，否则随机唤醒
 * notifyAll() : 同步锁执行此方法后，所有被阻塞的线程会被唤醒
 *
 *
 * 写了这个小例子还出了一点错，这里写一下感想
 * 1 notify()或notifyAll()之前不要有关于 同步数据的操作（判断），否则很有可能一个线程会阻塞，始终没有被唤醒，总之不要过河拆桥
 * 2 同步方法或同步代码块中关于同步数据的操作（判断或修改），一定不要多，也不要少
 *
 * 面试题 ：wait() 和 sleep()方法的异同
 * 同 ：都可以使线程阻塞
 * 异 ：方法的定义位置不同 ：wait()定义在Object类中，sleep()是Thread的静态方法
 *     方法的使用位置不同 ：wait()需要同步锁调用并且需要在同步方法或同步代码块中，而sleep()方法一般可以使用在任意位置
 *     阻塞的状态不同 ： wait()阻塞是WAITING,sleep()是TIMED_WAITING,
 *     是否释放锁 ：wait()会释放锁，而sleep()不会
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 14:56
 */
public class ObjectThreadTest {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number).start();
        new Thread(number).start();
        new Thread(number).start();
    }
}

class Number implements Runnable{
    int in = 1;
    int number = 100;

    public Number() {
    }

    public Number(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this){
                notifyAll();
                if(in <= number){

                    System.out.println(Thread.currentThread().getName() + " 打印了 ：" + in);
                    in++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }

        }
    }
}
