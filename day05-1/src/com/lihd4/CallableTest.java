package com.lihd4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程实现方式三 ： 实现Callable接口
 * 步骤 ：1 创建实现Callable接口的实现类
 *      2 重写call方法
 *      3 创建实现Callable接口的实现类
 *      4 创建FutureTask对象，传入callable对象
 *      5 创建Thread对象，传入FutureTask对象（这个类实现了 Runnable），start()启动线程
 *      6 使用FutureTask对象get()方法，返回call方法返回值
 *
 * FutureTask构造器 1 callable
 *                 2 runnable object
 *
 *
 * 多匿名的简便写法
 * new Thread(new FutureTask(new Callable)).start(); 太多的省略影响阅读
 *
 * 如何理解实现Callable接口比实现Runnable接口更加强大
 * 1 callable有返回值
 * 2 callable可以抛出异常
 * 3 callable支持泛型
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 19:08
 */
public class CallableTest {
    public static void main(String[] args) {

        Callable call = new MyCall();
        FutureTask<String> futureTask = new FutureTask<>(call);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        //*************************************************
        new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("111");
                return null;
            }
        })).start();


        //***************************************************
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("new Runnable");
            }
        };
        FutureTask task = new FutureTask(r, "result");
        new Thread(task).start();
        try {
            Object o = task.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class MyCall implements Callable<String>{

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("day05-1\\src\\com\\lihd4\\a.txt"));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
            sb.append(line);
        }
        return sb.toString();
    }
}