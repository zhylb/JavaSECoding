package com.lihd;

import org.junit.Test;

import java.util.function.Function;

/**
 * 1 Lambda介绍
 *      Lambda 是一个匿名函数，我们可以把 Lambda 表达式理解为是一段可以
 * 传递的代码（将代码像数据一样进行传递）。使用它可以写出更简洁、更
 * 灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了
 * 提升。
 * 2 Lambda本质
 *      函数式接口的匿名实现类对象 -> 本质是对象
 *      python - scale -> 本质是函数，
 * 3 函数式接口（见FunctionalTest）
 *      1 只包含一个抽象方法的接口，称为函数式接口。
 *      2 可以在一个接口上使用 @FunctionalInterface （since1.8）注解，这样做可以检查它是否是一个函数式接口
 *      3 javadoc 也会包含一条声明，说明这个接口是一个函数式接口
 *      4 在java.util.function包下定义了Java 8 的丰富的函数式接口
 * 4 格式
 *      左边 ：函数式接口抽象方法的形参列表,使用()
 *      -> : lambda操作符 或 箭头操作符
 *      右边 ：函数式接口抽象方法的方法体,使用{ } 包围
 * 5 如何省略
 *      左边 ：形参类型可以省略（类型推断），当且仅当形参列表个数为 1 时，可以省略括号
 *      -> : 这个省略不了
 *      右边 : 当且仅当只有一条语句时，可以省略{ },并且如果这一条语句时返回语句（return），如果要省略{}，则必须省略return
 *
 * 6 例子
 *      test01,test02
 *      更多例子请见 FunctionalTest.java
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 10:26
 */
public class LambdaTest {
    /**
     * Test01 : 初见lambda
     */
    @Test
    public void test01 (){
        //没有简化前
        Runnable r = () -> {
            System.out.println("runnable");
        };
        r.run();

        /*
        简化
        左边没有参数 不满足一个参数的情况，不可省略（）
        右边只有一个语句，可以省略{}
         */
        Runnable rs = () -> System.out.println("runnable simple");
        rs.run();
    }



    /**
     * Test02 : 这里先借用一下 函数式接口
     */
    @Test
    public void test02 (){
        Function<String ,Integer > fuc = (a) -> {
            return Integer.parseInt(a) * 100;
        };
        System.out.println(fuc.apply("89"));
        /*
        简化分析 ：
        左边 -> 只有一个参数，可以省略 ()
        右边 -> 只有一条语句，省略{}，然后由于省略{}，必须省略return
         */
//        Function<String ,Integer> fucSimple = a -> return Integer.parseInt(a) * 2; 报错
        Function<String ,Integer> fucSimple = a -> Integer.parseInt(a) * 2;
        System.out.println(fucSimple.apply("89"));

        /*
        更加简单
        改为方法引用
        注意这种方式就不能再 写一个 8 * Integer::parseInt什么的了，只能写 Integer::parseInt
         */
//        Function<String ,Integer> fucNew = Integer::parseInt * 3 ; 报错
        Function<String ,Integer> fucNew = Integer::parseInt ;
        System.out.println(fucNew.apply("56"));



    }
}
