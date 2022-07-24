package com.lihd.other;
import org.junit.Test;

import java.io.Console;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/11 8:35
 */
public class MyTest {

    /**
     * Test03 :
     *
     *
     *
     */
    @Test
    public  void test03 (){
        Console cons = System.console();
        String username = cons.readLine();
        char[] password = cons.readPassword();
        String s = new String(password);
        for (int i = 0; i < password.length; i++) {
            password[i] = 0;
        }
        password = null;
        System.out.println(username);
        System.out.println(password);


    }


    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 (){
        char a = 65;
        char b = 'A';
        char c = '\u0041';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println((int)c);
        String s = "\u0022+\u0022";
        System.out.println(s.length());
        System.out.println(""+'\u0022'+'\u0041'+'\u0042'+'\u0022');
    }


    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 (){
        // char a = '𝕆';会报错

        String hello = "hi𝕆";
        int length = hello.length();//返回代码单元个数 code unit
        for(int i=0;i<length;i++) {
            char charAt = hello.charAt(i);
            System.out.println(Integer.toHexString(charAt));
        }

        System.out.println("-----------------------------");
        int codePointCount = hello.codePointCount(0, length);//返回码点长度 code point
        for(int i=0;i<codePointCount;i++) {
            int index = hello.offsetByCodePoints(0,i);
            int charAt = hello.codePointAt(index);
            System.out.println(Integer.toHexString(charAt));
        }

    }


    public int reverse(int x) {

        int sum = 0;
        int h = x;
//        if(x < 0)  h = -x;
//        else h = x;
        int last = 0;
        do{
            sum = sum*10 + h%10;
            h = h/10;
            if(sum /10 != last){
                return 0;
            }
            last = sum;

        }while (h!=0);
//        if(x < 0) return -sum;
//        else return sum;
        return sum;
    }




}
