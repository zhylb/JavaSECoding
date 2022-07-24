package com.lihd;

import org.junit.Test;

import java.util.Scanner;

/**
 * |----- Throwable 异常根父类
 *      |------ Error 错误，一般不编写代码处理
 *      |------ Exception 异常
 *          |----- 编译时异常 （checked 受检异常）
  *              |----- IOException
 *                  |----- FileNotFoundException
 *              |----- ClassNotFoundException
 *          |------ 运行时异常（unchecked RuntimeException非受检异常）
 *              |----- NullPointerException （千古一异常，异常的神啊，你就是个 歌 姬 吧）
 *              |----- ArrayIndexOutOfBoundsException
 *              |----- InputMismatchException
 *              |----- ClassCastException
 *              |----- NumberFormatException
 *              |----- ArithmeticException
 * 注意
 * 编译时异常 如果不处理会在 javac编译时报错
 * 运行时异常 不处理 可能会在java后报错
 *
 * 可能什么都是短暂的吧，我有点难受了
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/4 14:46
 */
public class ExceptionTest {




    /**
     * Test06 : ArithmeticException
     * 数学错误
     *
     *
     */
    @Test
    public void test06 (){
        int a = 10/0;

    }



    /**
     * Test05 : NumberFormatException
     *
     *
     *
     */
    @Test
    public void test05 (){
        int abc = Integer.parseInt("abc");
    }



    /**
     * Test04 : ClassCastException
     *
     *
     *
     */
    @Test
    public void test04 (){
        //Scanner sc = (Scanner) new String(); //这样骗不过编译器

        Object s = "hello";
        Scanner sc = (Scanner) s; //可以骗过编译器


    }


    /**
     * Test03 : InputMismatchException
     * idea中好像不支持 这样输入，难啊
     *
     *
     */
    @Test
    public void test03 (){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);
    }



    /**
     * Test02 : ArrayIndexOutOfBoundsException
     * 补充一个 StringIndexOutOfBoundsException
     *
     */
    @Test
    public void test02 (){
        int[] arr = new int[3];
        System.out.println(arr[2]); //默认值是0，不要忘了哦
        System.out.println(arr[3]);

        //StringIndexOutOfBoundsException
        String s = "hello";
        System.out.println(s.charAt(10));

    }


    /**
     * Test01 : NullPointerException
     *
     *
     *
     */
    @Test
    public void test01 (){
        String s = null;
        System.out.println(s.toLowerCase());
    }
}
