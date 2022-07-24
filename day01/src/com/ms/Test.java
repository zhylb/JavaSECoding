package com.ms;

import java.io.PrintStream;

/**
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 16:02
 */
public class Test {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method();//要求method执行后仅打印 a = 100 \n b = 300
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    public static void method(int zhanwei){
        // 第一种方法 使用 System.exit(0)强制退出程序
        int a = 100;
        int b = 200;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.exit(0);
    }

    public static void method(){
        // 第二种方法 重写打印流
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String s) {

                if("a = 10".equals(s)){
                    s = "a = 100";
                }
                if("b = 10".equals(s)){
                    s = "b = 200";
                }

                super.println(s);
            }
        };
        // 重新设置打印流
        System.setOut(ps);
    }
}
