package com.java11.lihd;

import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * java11 LTS long term support
 *
 * 1 String 新增方法
 * 2 Optional 新增方法
 * 3 局部变量类型推断升级
 * 4 新特性 HTTPClient
 *      其不可直接可用 需要 requires java.net.http;
 * 5 更简洁的编译程序
 * 在命令行可以 直接 java Xxx.java
 * 这种方法只能使用这个文件中的类 不能使用其他类
 * 执行时有很多类时 只会执行最上面类的 main 方法
 * 6 更强大的垃圾回收器 ZGC 支持 64 位操作系统* GC 暂停不会超过 10ms
 * 既能处理几百兆的小堆, 也能处理几个 T 的大堆(OMG)
 * 和 G1 相比, 应用吞吐能力不会下降超过 15%
 * 为未来的 GC 功能和利用 colord 指针以及 Load barriers 优化
 奠定基础
 * 初始只支持 64 位系统
 * 7 废弃 Nashorn 引擎
 * 有需要的可以考虑使用 GraalVM
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 21:07
 */
public class OtherTest {

    public void myPrint(String  s){
        System.out.println("-----" + s + "-----");
    }


    /**
     * Test01 : String新增方法
     * 判断字符串是否为空白 " ".isBlank(); // true
     * 去除首尾空白 " Javastack ".strip(); // "Javastack"
     * 去除尾部空格 " Javastack ".stripTrailing(); // " Javastack"
     * 去除首部空格 " Javastack ".stripLeading(); // "Javastack "
     * 复制字符串 "Java".repeat(3);// "JavaJavaJava"
     * 行数统计 "A\nB\nC".lines().count(); // 3
     * Stream<String> = s.lines()
     *
     */
    @Test
    public void test01 (){
        //\u2000
        String s = "    \t hello \t \u2000 ";

        System.out.println(s.isBlank());//false 是否为空白
        System.out.println(s.isEmpty());//是否没内容

        myPrint(s.strip());
        myPrint(s.trim());//trim无法去除\u2000空白
        myPrint(s.stripLeading());
        myPrint(s.stripTrailing());

        String repeat = "java".repeat(3);
        System.out.println(repeat);


        s = "Hello\nWorld\nJava\nPython";
        Stream<String> lines = s.lines();
        lines.sorted(String::compareTo).forEach(System.out::println);
        s.lines().map(String::length).forEach(System.out::println);



    }

    /**
     * Test02 :
     * boolean isEmpty() 判断value是否为空 JDK 11
     * ifPresentOrElse (Consumer<?super T> action, Runnable emptyAction)value非空，执行参数1功能；如果value为空，执行参数2功能 JDK 9
     * Optional<T> or (Supplier<?extends Optional<? extends T>> supplier)value非空，返回对应的Optional；value为空，返回形参封装的OptionalJDK 9
     * Stream<T> stream() value非空，返回仅包含此value的Stream；否则，返回一个空的Stream JDK 9
     * T orElseThrow() value非空，返回value；否则抛异常NoSuchElementException JDK 10
     *
     */
    @Test
    public void test02 (){
        Optional<String> java = Optional.ofNullable("Java");
        java = Optional.empty();

        System.out.println(java.isEmpty());//false
        System.out.println(java.isPresent());//true

//        String s = java.orElseThrow();
//        System.out.println(s);


        java.ifPresentOrElse(System.out::println,() -> System.out.println("没有数据"));

        Optional<String> or = java.or(() -> Optional.of("难"));
        System.out.println(or);

    }

    /**
     * Test03 : var操作符升级
     *
     *
     *
     */
    @Test
    public void test03 (){
        Runnable r = () -> System.out.println("123");
        r.run();
        //Consumer<String> consumer = (@Deprecated@MyAnnotation s) -> System.out.println(s); //报错
        Consumer<String> consumer = (@MyAnnotation @Deprecated  var s) -> System.out.println(s);
        BiFunction<Integer,Integer,Integer> biFunction = (@MyAnnotation var a, @MyAnnotation @SuppressWarnings("unused") var b) -> Integer.sum(a,b);
    }



}
