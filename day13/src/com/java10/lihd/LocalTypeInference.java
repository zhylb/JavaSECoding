package com.java10.lihd;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  产生背景
 * 开发者经常抱怨Java中引用代码的程度。 局部变量的显示类型声明，常常被认为
 * 是不必须的，给一个好听的名字经常可以很清楚的表达出下面应该怎样继续。
 *  好处：
 * 减少了啰嗦和形式的代码，避免了信息冗余，而且对齐了变量名，更容易阅读！
 *  工作原理
 *       在处理 var时， 编译器先是查看表达式右边部分， 并根据右边变量值的类型进行推断， 作为左边变量的类型， 然后将该类型写入字节码当中
 * 启发 ：有三类情况无法使用类型推断
 *      1 没有右边 ：
 *              1.1 没有初始化的局部变量声明
 *              1.2 局部变量初始值为null
 *      2 根据左边推测右边
 *              2.1 lambda表达式
 *              2.2 方法引用
 *              2.3 数组静态初始化
 *      3 必须有类型要求
 *              3.1 方法返回值
 *              3.2 形参列表参数类型（可以归为情况1）
 *              3.3 构造器参数类型
 *              3.4 属性
 *              3.5 catch块
 *
 * 由于java是强类型语言，var并不会改变Java是一门静态类型语言的事实。 编译器负责推
 * 断出类型， 并把结果写入字节码文件， 就好像是开发人员自己敲入类型一样。
 *
 * 从代码来看，就好像之前已经声明了这些类型一样。事实上，这一特性只发
 * 生在编译阶段，与运行时无关，所以对运行时的性能不会产生任何影响。所
 * 以请放心，这不是 JavaScript
 *
 * 简言之 如果喜欢用就用，不会对效率产生影响
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 16:27
 */
public class LocalTypeInference {


    /**
     * Test00 : 使用var的举例
     *
     *
     *
     */
    @Test
    public void test00 () throws IOException {
        //这里如果使用try- catch会导致 那么 url.openConnection需要先声明为null
        var url = new URL("http://www.atguigu.com/");
        var urlConnection = url.openConnection();
        urlConnection.connect();


        var is = urlConnection.getInputStream();
        var os = new FileOutputStream("src/com/java10/lihd/a.html");

        is.transferTo(os);
        is.close();
        os.close();
        var urlConnection1 = (HttpURLConnection) urlConnection;
        urlConnection1.disconnect();
        /*  上面的程序的字节码反编译后 类型全部回来了
        URL url = new URL("http://www.atguigu.com/");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream os = new FileOutputStream("src/com/java10/lihd/a.html");
        is.transferTo(os);
        is.close();
        os.close();
        HttpURLConnection urlConnection1 = (HttpURLConnection)urlConnection;
        urlConnection1.disconnect();
         */
    }





    /**
     * Test01 : 没有右部
     */
    @Test
    public void test01 (){
        //var s ;

        //var a = null;
    }


    /**
     * Test02 : 根据左边推出右边
     */
    @Test
    public void test02 (){
        //2.1
        Predicate<Integer> pre = s -> s > 5;
//        var p = s -> s > 4;

        //2.2
        Consumer<String> con = System.out::println;
        // var con1 = System.out::println;


        //2.3
        int[] arr = new int[]{1,2,3};
        int[] arr1 = {1,2,3}; //根据左边推出右边
//        var  arr2 = {1,2,3};
    }

    /**
     * Test03 :确切的要求
     *
     */
    @Test
    public void test03 (){
        class Inner{
            //var s;//可能和类的加载有关，这个类型可能会使用默认值，然而类型推断是根据右边推出左边，因此不可能实现
            int age;
            //根本不知道传入了什么类型，无法进行下一步处理
            Inner(int a){//var a
                try{
                    int i = 1 / 0;

                }catch (Exception e){//var e//无法获取异常信息

                }
            }

            //本来是根据返回值类型严格要求返回值，如果使用var则什么类型都能返回
            public int  show(){//public var show()
                return 1;
            }
            //根本不知道传入了什么类型，无法进行下一步处理
            public void method(int a){// var a

            }
        }
    }
}
