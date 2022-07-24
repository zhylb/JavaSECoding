package com.lihd2;

/**
 * 可能输出的结果 ：
 * ab
 * 12
 * abcd
 * 1234
 *
 * cd
 * 34
 * cdab
 * 3412
 *
 * 死锁，什么也没有输出
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 20:32
 */
public class DeadLockTest1 {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        //先拿a,后拿b
        new Thread(() ->{
            synchronized (a){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.append("a");
                b.append("1");
                synchronized (b){

                    a.append("b");
                    b.append("2");
                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }).start();
        //先拿b,后拿a
        new Thread(() ->{
            synchronized (b){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.append("c");
                b.append("3");
                synchronized (a){

                    a.append("d");
                    b.append("4");
                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }).start();
    }
}
