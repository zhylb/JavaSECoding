package com.lihd2;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 1 System
 * 2 Math
 * 3 BigInteger,BigDecimal
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/10 13:26
 */
public class OtherClassTest {


    /**
     * Test03 : BigInteger,BigDecimal
     * 超高精度,用于商业，军事计算
     *
     *
     */
    @Test
    public void test03 (){
//        BigInteger bi = new BigInteger("12433241123");
//        BigDecimal bd = new BigDecimal("12435.351");
//        BigDecimal bd2 = new BigDecimal("11");
//        System.out.println(bi);
//        // System.out.println(bd.divide(bd2));
//        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
//        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
        BigInteger bi = new BigInteger("FFFFFFFFFFFFFFFFFFFFF",16);
        System.out.println(bi);

        BigDecimal bd = new BigDecimal("100000000000000000.000000");
        //System.out.println(bd.divide(new BigDecimal("3")));
        System.out.println(bd.divide(new BigDecimal("3"),BigDecimal.ROUND_HALF_DOWN));




    }



    /**
     * Test02 : Math
     * round
     * floorMod(position + adjustment, 12) 时钟问题
     *
     */
    @Test
    public void test02 (){
        System.out.println(Math.PI);
        System.out.println(Math.E);

        //四舍五入
        System.out.println(Math.round(5.4));
        System.out.println(Math.round(5.5));

        //ceil 向上，floor向下
        System.out.println(Math.floor(5.9));
        System.out.println(Math.ceil(5.1));

        //floorDiv
        System.out.println(Math.floorDiv(100, 7));

        System.out.println(Math.floorMod(100, 7));//2
        System.out.println(Math.floorMod(-100, 7));//5
        System.out.println(Math.floorMod(100, -7));//-5
        System.out.println(Math.floorMod(-100, -7));//-2

        //将一天24小时转换为 0-11
        System.out.println(Math.floorMod(5 + 9, 12));

        //防止数字溢出没有提示，这样数字溢出后会抛异常
        // java.lang.ArithmeticException: integer overflow
        System.out.println(Math.multiplyExact(1000000000, 3));


    }

    /**
     * Test01 : System
     * 静态属性 out,in,err
     * 静态方法
     * setIn()
     * setOut() 设置输入流，输出流 需要等待IO
     * ...
     * getProperty() 获取配置信息
     *
     * gc()通知进行垃圾回收
     * exit()程序退出
     *
     */
    @Test
    public void test01 (){
        System.out.println(System.out);
        System.out.println(System.in);
        System.out.println(System.err);

        System.out.println(System.currentTimeMillis());


        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));

        System.gc();//通知进行垃圾回收，不一定立马就要开始
        System.exit(0);//程序退出，0表示正常，其他表示非正常
    }


}
