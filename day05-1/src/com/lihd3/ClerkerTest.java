package com.lihd3;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 15:28
 */
public class ClerkerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk(15);
        Object lock = new Object();
        new Thread(new Producer(clerk,lock)).start();
        //new Thread(new Producer(clerk)).start();
        //new Thread(new Producer(clerk)).start();
        new Thread(new Consumer(clerk,lock)).start();
    }
}

class Producer implements Runnable{
    Clerk clerk;
    Object lock;

    public Producer(Clerk clerk, Object lock) {
        this.clerk = clerk;
        this.lock = lock;
        System.out.println(lock);
    }

    @Override
    public void run() {
        while(true){
            produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void produce(){
        synchronized (lock){
            lock.notifyAll();
            if(clerk.num < clerk.maxNum){
                clerk.num = clerk.num + 1;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "生产了第 " + clerk.num + " 个产品");

            }else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable{
    Clerk clerk;
    Object lock;

    public Consumer(Clerk clerk, Object lock) {
        this.clerk = clerk;
        this.lock = lock;
        System.out.println(lock);
    }

    public void consume(){
        synchronized (lock){
            lock.notifyAll();
            if(clerk.num > 0){
                System.out.println(Thread.currentThread().getName() + "消费了第 " + clerk.num + " 个产品");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.num = clerk.num - 1;

            }else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        while (true){
            consume();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Clerk{
    int maxNum = 100;
    int num;
    public Clerk() {

    }

    public Clerk(int maxNum) {
        this.maxNum = maxNum;
    }

}
