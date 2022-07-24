package com.lihd;

import org.junit.Test;

import java.io.*;

/**
 * 1 Finally 是可选的 catch也是可选的
 * 2 finally 是一定会执行的，无论是否发生错误，无论是否有return
 * 3 finally 一般用在 代码中一定想执行的 或 资源关闭
 *
 * 如果一个方法有返回值，确只有try-finally 其中的异常好像被自动处理了
 * 仔细观察test00 和 test01 不知道为什么
 *
 * finally中不要有返回语句，因为这代表着无论如何返回值为那个值
 *
 * 一般可以不处理运行时异常
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 19:15
 */
public class FinallyTest {

    /**
     * Test03 : 处理经典文件异常
     * 这个文件中try-catch-finally发生异常，逻辑十分严密，体现了java超凡的严谨
     * 但是确非常臃肿，比较影响阅读
     *
     *
     */
    @Test
    public void test03 (){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            bis = new BufferedInputStream(new FileInputStream(new File("src/com/lihd/a.png")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("src/com/lihd/b.png")));

            byte[] buffer = new byte[1024*8];
            int len;
            while((len = bis.read(buffer)) != -1 ){
                bos.write(buffer,0,len);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 (){
        int a = test01();
        System.out.println(a);
        int b = test00();
        System.out.println(b);

    }


    /**
     * Test01 : 测试执行顺序
     */
    public int test01() {
        try{
            int a = 1;
            int b = 0;
            System.out.println(a/b);
            System.out.println("你怎么还不见我");
            String s = null;
            s.toUpperCase();
            return 1;
        }catch (NullPointerException e){
            System.out.println("我心目中的白马王子");
            return 2;
        }catch (ArithmeticException e){
            System.out.println("你就是对的人");
            return 3;
        }finally {
            System.out.println("岁月荏苒，当初说永远在一起的人的，似乎已经十年没见到了");
            return 4;
        }

    }

    public int test00(){
        try{
            int a = 1;
            int b = 0;
            System.out.println(a/b);
            System.out.println("你怎么还不见我");
            String s = null;
            s.toUpperCase();
            return 1;
        }finally {
            //异常呢，是隐藏了catch自动被处理了
            System.out.println("岁月荏苒，当初说永远在一起的人的，似乎已经十年没见到了");
            return 4;
        }
    }

}
