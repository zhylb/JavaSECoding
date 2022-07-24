package com.lihd1;

/**
 * 请先分析结果哦
 *
 * 面试题 throw和throws有什么区别
 * throw是产生异常的方式，他是自己new完异常后throw的 声明在方法内
 * throws是处理异常的方式，他的处理方式是将异常反馈给方法的调用者 声明在方法声明处
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 21:14
 */
public class Exer {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        }finally {
            System.out.println("用A方法的finally");
        }
    }
    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("调用B方法的finally");
        }
    }
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        methodB();
    }

}
