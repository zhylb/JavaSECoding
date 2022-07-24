package com.lihd5;

import org.junit.Test;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 9:50
 */
public class WrapperMethodTest {

    /**
     * Test01 : Integer的部分使用静态方法
     *
     *
     *
     */
    @Test
    public void test01 (){

        String binaryString = Integer.toBinaryString(89);
        String octalString = Integer.toOctalString(89);
        String hexString = Integer.toHexString(89);
        long l = Integer.toUnsignedLong(89);
        System.out.println("binaryString = " + binaryString);
        System.out.println("octalString = " + octalString);
        System.out.println("hexString = " + hexString);
        System.out.println("l = " + l);
    }
}
