package com.lihd;

import org.junit.Test;

import java.io.FileReader;

/**
 *
 * 异常的处理 抓抛模型
 * 过程一 抛：异常的生成方式 程序执行过程中，一旦发生异常，会在异常处生成一个对应异常类的对象，并将此对象抛出
 *          对象抛出以后，其后的代码就不再执行
 *
 *          异常生成方式 ： 系统自动生成
 *                        手动new
 *
 * 过程二 抓：异常的处理方式 1 try-catch-finally 2 throws
 *
 * 1 try-catch-finally 类比与 switch-case-default finally是可选的
 * 2 使用try将可能发生异常的代码包装起来，如果发生异常，这个异常类生成的对象就会去catch中进行匹配
 * 3 如果匹配到了catch,那么就会进入catch块，然后如果没有finally,那么就会跳出try-catch结构
 *   如果没有匹配成功，那么相当于没有这个try-catch块
 * 4 catch中异常类型如果没有子父类关系，那么顺序无所谓，如果有，那么父类一定要在下面，否则编译通不过
 * 5 catch块中常用的异常处理方式 e.getMessage() e.printStackTrace()
 * 6 try 中声明的变量和catch块中变量都是局部变量
 * 7 try-catch-finally是可嵌套的
 *
 *
 * try-catch-finally处理的编译时异常，可以在编译期间不在报错，但是程序的正确性不能保证，将可能出现的异常出现时期延后
 *
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 18:16
 */
public class ExceptionTest1 {

    /**
     * Test02 : 处理运行时 异常
     *
     * 没有特殊要求，不用处理，否则代码太臃肿效率低下。
     *
     */
    @Test
    public void test02 (){

        try{

            int a = 3/0;
            System.out.println("我们会在见面的，对吗？下次再见面，我们就结婚");

        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("终究还是没有等到那个人啊");

    }

    /**
     * Test01 : 处理编译期 异常
     * 程序正常结束，但是没有达到目的
     *
     *
     */
    @Test
    public void test01 (){
        try{
            //
            FileReader fr = new FileReader("hello.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
