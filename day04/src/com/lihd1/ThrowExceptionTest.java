package com.lihd1;

/**
 * 手动抛出异常
 * 一般建议抛出运行时异常 throw
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 21:07
 */
public class ThrowExceptionTest {
    public static void main(String[] args) {
        test01(100);

        try {
            test02(2);
        } catch (LoveOtherException e) {
            e.printStackTrace();
        }
    }

    public static void test01(int a){
        if(a > 10){
            System.out.println("i love you ");
        }else {
            //运行时异常 不需要抛出
            throw new LoveYouException("你为什么不爱我");
        }

    }

    public static void test02(int b) throws LoveOtherException{
        if(b > 10){
            System.out.println("never gone");
        }else {
            //编译期异常需要 try-catch或者 throws
            throw new LoveOtherException("你得处理了");
        }



    }

    public static void test03(){
        try{
            //手动抛出异常处理方式二 try-catch
            throw new LoveOtherException("hello");
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }





}
