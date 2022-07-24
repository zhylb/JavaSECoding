package com.lihd;
import org.junit.Test;
/**
 * @date ：2022/3/8 21:18
 */
public class StringTest {
    /**
     * Test01 : 初见String
     * 在java17中String声明如下
     * public final class String
     *     implements java.io.Serializable, Comparable<String>, CharSequence,
     *                Constable(12), ConstantDesc(12) {
     * @Stable
     * private final byte[] value;
     *
     * 1 String不可被继承
     * 2 String实现了Serializable接口，可以序列化
     * 3 String实现了Comparable接口，可以比较大小
     * 4 final byte[] value;
     *
     * 由此可见String是不可变序列，不可变性
     * 理解String的不可变性
     * 通过字面量方式给一个字符串赋值，此时字符串声明在方法区的字符串常量池中
     * 字符串常量池中不会有相同的字符串
     * 改变一个字符串的值，会在字符串常量池中重新开辟或找到对应的字符串值
     *
     * java中字符 不可变性 的原因：
     * 《core Java》:
     * Java设计者认为 共享带来的高效率远超过提取子串，拼接字符串所带来的低效率
     *
     *
     */
    @Test
    public void test01 (){
        String s = "hello";//通过字面量赋值
        //只要字符串发生一丁点改动，那就要找到或开辟一个新的空间
        String ss = s.replace('l','n');
        System.out.println(ss);
        System.out.println(s == ss);

        System.out.println("------------------------------------");
        String s1 = "abc";
        Object j;
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        //hashCode不能比较地址，只是一个hash值，下面是比较地址
        System.out.println(Utils.objectAddress(s1));//0x44c30ec00
        System.out.println(Utils.objectAddress(s2));//0x44c30ed80

        s2 = "123";
        s1 = new String("123");
        System.out.println(s1 == s2);
        System.out.println(Utils.objectAddress(s1));
        System.out.println(Utils.objectAddress(s2));
        //输出结果
        //false
        //0x44c30ef80
        //0x44c30f100
        //false
        //0x44c3558c0
        //0x44c355740
        //为什么这几个值如此接近，
        //猜测1 这个ObjectAddress只能获取 堆中的地址，可是怎么回答刚开始s1 = "abc"的疑问
        //猜测2 这个ObjectAddress在特定情况下不正确
        //猜测3 java17中内存区域发生了变化，我不太理解结果 （改变jdk后，发现这个猜测错了）
    }


    /**
     * Test02 : 字符串实例化 方式
     * 1 字母量 : String s = "hello";
     * 2 new : String s = new String("hello");
     * 问 ：通过new方式在内存中开辟了几个对象
     * 两个
     * 1 一个是new在堆中开辟的空间
     * 2 另一个是在方法区的常量池中开辟的空间byte[] “hello"
     *
     * 总结 ：
     * 通过s1 == s2 结果为true可以联想一下
     * 如果有两个对象，都有一个String类型的值为 name = "hello"
     * 那么这两个对象 == 的结果相等吗？ --》 结果为true
     * 还是那句话，java设计者认为共享的高效性超过拼接替换的操作带来的低效性
     *
     *
     */
    @Test
    public void test02 (){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false
    }


    /**
     * Test03 : 字符串拼接问题
     * 关于拼接后的地址问题，注意
     * 1 常量 与 常量 连接结果在常量池中（声明为final的量也是常量哦,但是new的常量不行，需要的是字面量的常量）
     * 2 只要有变量参与连接 结果就在堆中新开辟，哪怕这个变量调用了intern()方法 比如s3 == s7 为false
     * 3 对一个在堆中的String,使用intern()方法，结果返回在常量池中
     *
     *
     */
    @Test
    public void test03 (){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = "helloworld";
        String s5 = s1 + "world";
        String s6 = s1 + s2;
        String s7 = s1.intern() + s2.intern();
        String s8 = s6.intern();
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s3 == s8);//true
        final String s9 = new String("hello");
        final String s10 = "hello";
        String s11 = s9 + "world";
        String s12 = s10 + "world";
        System.out.println(s3 == s11);//false
        System.out.println(s3 == s12);//true

    }


}
