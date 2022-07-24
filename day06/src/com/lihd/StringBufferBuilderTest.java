package com.lihd;

import org.junit.Test;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/9 15:48
 */
public class StringBufferBuilderTest {



    /**
     * Test04 : 频繁尾加效率对比
     * 效率对比
     * StringBuilder > StringBuffer > String
     *
     *
     *
     * StringBuffer所用时间 ： 19
     * StringBuilder所用时间 ： 5
     * String所用时间 ： 2660
     */
    @Test
    public void test04 (){
        long begin;
        long end;
        String string = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        begin = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            stringBuffer.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer所用时间 ： " + (end - begin) );

        begin = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            stringBuilder.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder所用时间 ： " + (end - begin) );

        begin = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            string += i;
        }
        end = System.currentTimeMillis();
        System.out.println("String所用时间 ： " + (end - begin) );

    }

    /**
     * Test03 : StringBuffer常用方法
     * 返回自身的方法支持链式编程 原理 ：return this;因此可以用 a.append().append().append().append()...
     * StringBuffer append(xxx)：提供了很多的append()方法， 用于进行字符串拼接
     * StringBuffer delete(int start,int end)：删除指定位置的内容 [)
     * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * StringBuffer reverse() ：把当前字符序列逆转
     *
     * public int indexOf(String str)
     * public String substring(int start,int end)
     * public int length()
     * public char charAt(int n )
     * public void setCharAt(int n ,char ch)
     *
     * 需要掌握的方法
     * 1 增 ： append
     * 2 删 ：delete
     * 3 改 ：replace
     * 4 查 ：charAt
     * 5 插 ：insert
     * 6 长度 ：length
     * 7 遍历 ：charAt + for
     *
     *
     */
    @Test
    public void test03 (){

        System.out.println("下面的方法都会改变自身 ");
        StringBuffer sb = new StringBuffer("0123456789");
        System.out.println(sb.append("false"));

        System.out.println(sb.delete(10, 15));//左闭右开[)

        System.out.println(sb.replace(2,4,"32"));//0132456789

        System.out.println(sb.insert(4, "AA"));

        System.out.println(sb.reverse());
        System.out.println("下面的方法更多的是一种查询方法 setCharAt会改变自身");

        System.out.println(sb.substring(1,5));
        System.out.println(sb.length());
        sb.setCharAt(0,'Z');


        System.out.println(sb);



    }




    /**
     * Test02 : 底层分析
     * 对于String
     * String s1 = new String() //byte[] = new byte[0];
     * String s2 = new String("abc") //byte[] = new byte[3]{'a','b','c'};
     *
     * 对于StringBuffer或StringBuilder
     * StringBuffer s1 = new StringBuffer();//byte[] = new byte[16]
     * StringBuffer s2 = new StringBuffer("abc");//byte[] = new byte["abc".length + 16]
     * StringBuffer s3 = new StringBUffer(num);//如果num > 16 value = new byte[num] 否则 value = new byte[16]
     *
     * 在java8中扩容为  原来的两倍 + 2，如果两倍 + 2还不够，那就和你一样大，
     * 为什么要+2，因为java8中使用char[]存储，一个分割符可能要有两个字符构成，高瞻远瞩
     * 在java17中没有看懂  ArraysSupport.newLength(oldLength, growth, oldLength + (2 << coder));
     * 这个coder是编码格式 ，采用utf16或其他，也就是说扩容为 （原来长度 + 2） 如果不够就和你一样大
     *
     *
     *
     */
    @Test
    public void test02 (){
        StringBuffer s;

    }


    /**
     * Test01 : 比较三者
     * 这是java17，java8使用的是char[]
     * 请说明一下String StringBuffer StringBuilder
     * String不可变的字符序列 private final byte[] value;
     * StringBuffer可变的字符序列   byte[] value; 线程安全，效率低
     * StringBuilder可变的字符序列 jdk1.5新增，线程不安全，效率高
     *
     */
    @Test
    public void test01 (){
        StringBuffer s = new StringBuffer("abc");
        s.setCharAt(0,'z');
        System.out.println(s);//zbc 说明s已经被改变

    }
}
