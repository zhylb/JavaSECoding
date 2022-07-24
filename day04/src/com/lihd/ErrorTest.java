package com.lihd;

/**
 * 首先异常不是语法错误，也不是逻辑错误
 * 异常是不可避免的
 *
 * 异常分为 Error 和 Exception
 *
 * 这里举例两个Error的例子
 * 一个是堆溢出 一个是栈溢出
 * 需要明白的是 这种错误java虚拟机无法处理，没有特别的针对手段 建议编码时尽可能避免
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/4 14:27
 */
public class ErrorTest {
    public static void main(String[] args) {

        //1 栈溢出 一般是递归调用
        //main(args); //java.lang.StackOverflowError




        //2 堆溢出 堆的空间不够大 申请4gb的内存
        //int[] arr = new int[1024*1024*1024];//java.lang.OutOfMemoryError: Java heap space

        String s = "****************************".repeat(10000000).intern();
        while(true){
            s += "****************************".repeat(10000000).intern();
            System.out.println(s);
        }
    }
}
