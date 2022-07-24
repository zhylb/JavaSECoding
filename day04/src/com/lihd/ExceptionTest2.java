package com.lihd;

import java.io.*;

/**
 * 异常处理方式二 ： throws + 异常类型，如果有 多个用，隔开
 *
 * 向上抛出，严格来说这并不是一种处理方式，因为本质上异常还是存在
 * 可以一直向方法的调用者抛出，但是如果main方法中也抛出了异常，会抛给虚拟机，程序将会异常结束
 * 异常抛出后，异常后的代码将不再执行
 *
 * tips
 * 1 什么时候抛出，什么时候catch呢
 *  如果父类没有抛出异常，那么子类要处理异常时，必须使用catch
 *  如果方法a是b,c,d三个有上下关系的方法构成，那么方法a 采用try-catch-finally  ,方法 b,c,d使用throws
 *
 * 子类抛出异常不应该大于父类抛出的异常，保证多态情况下父类的catch可以包括所有可以发生的异常
 *
 * 编译时异常一定要处理，运行时异常可以不处理
 * 发生异常后，要找到发生异常的原因并且处理，而不是简单的try-catch处理，这样并没有实际解决问题，这个问题始终会发生
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 20:13
 */
public class ExceptionTest2 {


    public static void main(String[] args) {
        try {//在main中处理，虽然main方也可以抛给虚拟机，但是非常不建议
            method02();
        } catch (Exception e) {
            e.printStackTrace();
        }
        method01();
    }


    public static void method02() throws Exception{//向上抛出，并且扩大了异常范围
        throwMethod();
    }


    public static void method01(){//异常被处理
        try {
            throwMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void throwMethod() throws FileNotFoundException, IOException {//向上抛出异常
        BufferedReader br = new BufferedReader(new FileReader(new File("aaa.txt")));
        br.readLine();
    }
}
