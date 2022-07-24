package com.lihd;

/**
 * Main 方法是入口
 * 一个文件中声明为 public 类需要有main方法 才能正确运行
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 23:26
 */
public class MainTest {
    public static void main(String[] args) {
        OtherMain.main(null);
    }
}

class OtherMain{
    public static void main(String[] args) {
        args = new String[10];
        for (int i = 0; i < args.length; i++) {
            System.out.println(i);
        }
    }
}