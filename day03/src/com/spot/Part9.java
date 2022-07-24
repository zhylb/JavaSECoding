package com.spot;

import java.util.*;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/21 23:19
 */
public class Part9 {

    public static void main(String[] args) {
        Process A = new Process("A",0,3);
        Process B = new Process("B",2,6);
        Process C = new Process("C",4,4);
        Process D = new Process("D",6,5);
        Process E = new Process("E",8,2);

//        Process A = new Process("A",0,3);
//        Process B = new Process("B",1,5);
//        Process C = new Process("C",3,2);
//        Process D = new Process("D",9,5);
//        Process E = new Process("E",12,5);


        Process[] arr = {A,B,C,D,E};

        //fcfs(arr);
        //rr(arr,4);
        //spn(arr);
        //srt(arr);
        hrrn(arr);
    }
    public static void fcfs(Process[] arr){
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            time += arr[i].getLeft();
            System.out.println(arr[i].getName() + " ：" + time);
        }
    }

    public static void rr(Process[] arr,int q){
        //轮转算法
        Queue<Process> queue = new LinkedList<>();//这个队列是 就绪队列
        Queue<Process> begin = new LinkedList<>();//这个队列是 还没有进入的队列
        for (int i = 0; i < arr.length; i++) {
            begin.offer(arr[i]);
        }
        queue.offer(begin.poll());//先放一个到offer中
        int i = 0;
        while(!queue.isEmpty()) {
            i += q;
            if(!begin.isEmpty()){
                Process ppp = begin.peek();
                if(ppp.arrive <= i){
                    queue.offer(ppp);
                    begin.poll();
                }
            }
            Process poll = queue.poll();
            System.out.print(poll.getName() + " : ");
            if(poll.left > q){
                System.out.println(q);
            }else {
                System.out.println(poll.left);
            }
            poll.left = poll.left - q;
            if(poll.left > 0){
                queue.offer(poll);
            }
        }
    }



    public static void spn(Process[] arr){
        Queue<Process> begin = new LinkedList<>();//这个队列是 还没有进入的队列
        for (int i = 0; i < arr.length; i++) {
            begin.offer(arr[i]);
        }
        int i = 0;
        while(!begin.isEmpty()){
            int finalI = i;//这个是必须的 解释一下吧
            /*
            一个匿名对象调用了外面的值，这个值一定要是final常量
            因为即使外面的被引用的对象被销毁，外面的基本数据类型因为出栈被销毁
            都不该影响匿名类中的方法中的对象和基本数据类型
            因此在这样的情况下，匿名类中会存储一个副本，如果这个值可以任意改变
            会导致副本和外面的值不一致这种情况，因此这个值不可改变。
            不得不说，java严谨且啰嗦
             */
            Process process = begin.stream().filter(a -> a.arrive <= finalI).min(Comparator.comparingInt(a -> a.left)).get();
            begin.remove(process);
            i+= process.getLeft();
            System.out.println(process.getName() + " : " + process.getLeft());

        }
    }

    public static void srt(Process[] arr){
        //抢占
        Queue<Process> queue = new LinkedList<>();//这个队列是 就绪队列
        Queue<Process> begin = new LinkedList<>();//这个队列是 还没有进入的队列
        for (int i = 0; i < arr.length; i++) {
            begin.offer(arr[i]);
        }
        queue.offer(begin.poll());
        int i = 0;
        while(!queue.isEmpty()){
            i ++;
            int finalI = i;
            Process process = queue.stream().filter(a -> a.arrive <= finalI).min(Comparator.comparingInt(a -> a.left)).get();
            queue.remove(process);
            System.out.println(process.getName() + " : 1");
            process.left = process.left - 1;
            if(process.left > 0){
                queue.offer(process);
            }

            if(!begin.isEmpty()){
                Process ppp = begin.peek();
                if(ppp.arrive == i){
                    begin.poll();
                    queue.offer(ppp);
                }
            }

        }
    }

    public static void hrrn(Process[] arr){
        Queue<Process> begin = new LinkedList<>();//这个队列是 还没有进入的队列
        for (int i = 0; i < arr.length; i++) {
            begin.offer(arr[i]);
        }
        int i = 0;
        while(!begin.isEmpty()){
            int finalI = i;
            Process process = begin.stream().filter(a -> a.arrive <= finalI).max(Comparator.comparingDouble(a -> (0.0+finalI-a.arrive)/a.left)).get();
            begin.remove(process);
            i+= process.getLeft();
            System.out.println(process.getName() + " : " + process.getLeft());

        }
    }

    public static void feedback(Process[] arr){
        Queue<Process> queue = new LinkedList<>();
        Queue<Process> begin = new LinkedList<>();//这个队列是 还没有进入的队列
        for (int i = 0; i < arr.length; i++) {
            begin.offer(arr[i]);
        }
        queue.offer(begin.poll());
        int i = 0;

        while(true){
            i++;
            if(!begin.isEmpty()) {
                Process ppp = begin.peek();
                if (ppp.arrive <= i) {
                    queue.offer(ppp);
                    begin.poll();
                }
            }
        }


    }





}

class Process{
    String name;
    int arrive = 0;
    int service = 0;
    int left;
    int prior;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public Process(String name,int arrive, int service) {
        this.name = name;
        this.arrive = arrive;
        this.service = service;
        this.left = this.service;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", arrive=" + arrive +
                ", service=" + service +
                ", left=" + left +
                '}';
    }
}
