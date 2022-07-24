package com.lihd5;

import org.junit.Test;

/**
 * 包装类
 * 为了基本数据有类的特征
 *
 * 记得包装类中各种实用的方法
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 0:14
 */
public class WrapperTest {



    /**
     * Test04 : 与字符串的转换
     *
     *
     *
     */
    @Test
    public void test04 (){
        //数值转字符串
        // 1 和空串相连
        // 2 使用 String.valueOf()
        Integer in1 = 23;
        String s1 = in1 + "";

        Character ch1 = 24;
        String s2 = String.valueOf(ch1);


        //字符串转数值
        //1 使用构造器 见test01
        //2 使用包装类的 parseXxx

        //和Boolean的构造器差不多
        Boolean b1 = Boolean.parseBoolean("35");
        System.out.println(b1);//false

        Long l = Long.parseLong("898709870");//这里不要加L
        System.out.println(l);
    //可能会报错
//        int a = Integer.parseInt("io");
//        System.out.println(a);


    }


    /**
     * Test03 : JDK1.5 新增 : 自动拆装箱
     *
     *
     *
     *
     */
    @Test
    public void test03 (){
        int a = 10;


        //如果认为是 Object o = int a那么大错特错
        //实际上是 Object o = Integer a 因为有自动装箱
        //于是参数为Object类型方法可以传入任意对象, 基本数据类型也可以
        // (先自动装箱为包装类, 再通过多态赋值给父类Object)
        consume(a);//10

        //自动装箱
        Integer in1 = 10;
        Double Du = 23.4;

        //自动拆箱
        int c = in1;
        double d = Du;

    }

    public void consume(Object o){
        System.out.println(o);
    }


    /**
     * Test02 : 包装类到基本数据类型
     * 使用 xxxValue , 注意每个包装类都有各个xxxValue 并不是只有对应的
     * 比如 Double 的对象有 intValue;
     *
     *
     */
    @Test
    public void test02 (){
        class V{
            boolean b1;
            Boolean b2;
        }
        V v = new V();
        System.out.println(v.b1);//false 初始化为假
        System.out.println(v.b2);//引用数据类型 结果为null

        Integer in1 = new Integer("98");
        int a = in1.intValue();
        System.out.println(a);

        Float f = new Float(23.9f);
        double d = f.byteValue();
        double c = f.floatValue();
        int b = f.intValue();
        System.out.println(d);//23.0
        //浮点数并不是精确表示的
        System.out.println(c);//23.899999618530273
        System.out.println(b);//23

    }

    /**
     * Test01 : 基本数据 -> 包装类 使用构造器
     * 探究 Boolean的构造器
     * 1    public Boolean(String s) { this(parseBoolean(s));}
     *
     * 2    public static boolean parseBoolean(String s) {
     *         return ((s != null) && s.equalsIgnoreCase("true"));
     *      }
     * 由上的源码可知 Boolean可以传入任何字符串 在忽略大小写的情况下 为true时 结果为true
     * 其他的结果都是FALSE
     */
    @Test
    public void test01 (){
        Integer in1 = new Integer(12);
        Float fl1 = new Float("12.3f");
        // Float fl2 = new Float("hahah"); NumberFormatException
        System.out.println("in1 = " + in1);
        System.out.println("fl1 = " + fl1);

        //特别的 关于Boolean
        Boolean b1 = new Boolean("去你码的");
        System.out.println(b1);//false
        Boolean b2 = new Boolean("tRue");
        System.out.println(b2);//true
    }
}
