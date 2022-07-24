package com.exer;

/**
 * 测试类
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 21:33
 */
public class PrintClassTest {

    public static void main(String[] args) {
        String s;
        PrintClass pc;
        pc = new PrintClass("java.lang.String");
        pc = new PrintClass("com.lihd1.Son");
        pc = new PrintClass("java.util.HashMap");
        pc.print();
    }

}
