package com.lihd;

import org.junit.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 1 函数式接口
 *      1 只包含一个抽象方法的接口，称为函数式接口。
 *      2 可以在一个接口上使用 @FunctionalInterface （since1.8）注解，这样做可以检查它是否是一个函数式接口
 *      3 javadoc 也会包含一条声明，说明这个接口是一个函数式接口
 *      4 在java.util.function包下定义了Java 8 的丰富的函数式接口
 * 2 四大核心接口
 *      接口                      参数类型    返回类型            说明
 *      Consumer<T>     消费型接口   T       void            对类型为 void accept(T t) T的对象应用操作，包含方法：
 *      Supplier<T>     供给型接口   无       T               返回类型为T的对象，包含方法： T get()
 *      Function<T, R>  函数型接口   T       R               对类型为 果是R类型的对象。包含 T的对象应用操作，并返回结果 方法： R apply(T t)
 *      Predicate<T>    断定型接口   T       boolean         确定类型为 boolean 值。包含 T的对象是否满足某约束，并返回
 * 3 其他接口
 *      接口                   参数类型 返回类型          说明
 *      BiFunction<T, U, R>     T, U    R           对类型为 T, U 参数应用操作， 返回 R 类型的结果。 包含方法为： R apply(T t, U u);
 *      UnaryOperator<T>        T       T           对类型为 结果。 包含方法 T的对象进行一元运算 为： T apply(T t)，; 并返回T类型的
 *      BinaryOperator<T>       T, T    T           对类型为 结果。 包含方法 T的对象进行二元运算 为： T apply(T，t1并返回 , T t2);T类型的
 *      BiConsumer<T, U>        T,      U           void 对类型为T, U 参数应用操作。包含方法为： void accept(T t, U u)
 *      BiPredicate<T,U>        T,U     boolean     包含方法为： boolean test(T t,U u)
 *
 *      UnaryOperator 是 Function子接口
 *      BinaryOperator 是 BiFunction 子接口
 *
 *      ToIntFunction<T> ToLongFunction<T> ToDoubleFunction<T>  分别计算int、 long、 double值的函数
 *      IntFunction<R> LongFunction<R> DoubleFunction<R>       参数分别为int、 long、 double 类型的函数
 * 5 记忆
 *      consumer - accept
 *      supplier - get
 *      function - apply
 *      predicate - test
 *      泛型参数顺序 -> 先传入，后返回
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 11:05
 */
public class FunctionalTest {
    /**
     * Test01 : Consumer
     */
    @Test
    public void test01 (){
        //1 输入小写转为大写
        Consumer<String> cons = s -> System.out.println(s.toUpperCase());
        cons.accept("hello World");
    }
    /**
     * Test02 : Supplier
     */
    @Test
    public void test02 (){
        //1 获取一个随机数
        Supplier<Integer> sup = () ->  new Random().nextInt();
        Integer integer = sup.get();
        System.out.println(integer);
        //2 获取一个随机字符串
        Supplier<String> supString = () ->{
            String[] s1 = {"我","你","他","她","它"};
            String[] s2 = {"爱","恨","咬","打","骂"};
            Random random = new Random();
            return s1[random.nextInt(5)] + s2[random.nextInt(5)] + s1[random.nextInt(5)];
        };
        for (int i = 0; i < 5; i++) {
            System.out.println(supString.get());
        }


    }

    /**
     * Test03 : Function
     * andThen() -> func1.apply(func2) 返回符合接口 先func1 后 func2;
     * compose() -> func1.compose(func2) 返回复合接口 先func2 后 func1;
     */
    @Test
    public void test03 (){

        //func1 : f(x) = x + 2
        Function<Double,Double> func1 = a -> a + 1;
        //func2 : f(x) = x * x
        Function<Double,Double> func2 = a -> Math.pow(a,2);


        Function<Double,Double> func3 = func1.andThen(func2);

        Function<Double,Double> func4 = func1.compose(func2);

        Function<Double, Double> func5 = func2.andThen(func1);

        Function<Double,Double> func6 = func2.compose(func1);

        double num = 3;
        Double apply1 = func3.apply(num);
        Double apply2 = func4.apply(num);
        Double apply3 = func5.apply(num);
        Double apply4 = func6.apply(num);
        System.out.println("apply1 = " + apply1);
        System.out.println("apply2 = " + apply2);
        System.out.println("apply3 = " + apply3);
        System.out.println("apply4 = " + apply4);

        System.out.println(func3 == func6);//false
        System.out.println(func4 == func5);//false



    }

    /**
     * Test04 : Predicate
     *
     */
    @Test
    public void test04 (){
        //1 判断一个字符串是否含有字符 "帅”
        Predicate<String > pred = a -> a.contains("帅");
        System.out.println(pred.test("大帅比"));//true

        Predicate<String> and = pred.and(s -> s.contains("大"));
        System.out.println(and.test("大帅比"));//true

        Predicate<String> negate = pred.negate();
        System.out.println(negate.test("大帅比"));//false
    }


}
