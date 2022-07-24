package com.lihd1;

/**
 * 可变个数形参
 * JDK5.0 新增
 * 具体使用 :
 *      1 声明格式 : 数据类型 ... 变量名
 *      2 传入参数可以是 0 个 1 个 2 个...
 *      3 与方法名相同 参数列表不同的方法构成重载
 *      4 与方法名形同 参数列表相同的数组之间不构成重载 , 两者不能同时存在
 *      5 可变个数形参必须声明在末尾, 因此至多有一个可变个数形参
 *
 * 可以理解为 可变形参个数就是一个数组 , 只能声明在末尾, 只不过调用时可以有更好的方式
 * 因此 数组可以有多个 也不必要在形参列表的末尾
 *
 * 当类中存在 show(String) 和 show(String...)时
 * 调用 show("a") 会使用show(String ) 因为比较具体一点
 *
 *
 * 当类中同时存在 show(String) show(String,String...) show(String...)
 * 构成重载 但是 show("a","a") 会报错 因为不知道调用那个方法
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 14:47
 */
public class MethodArgsTest {

    public static void main(String[] args) {
        MethodArgsTest t = new MethodArgsTest();
        t.show();
        t.show("hello");
        t.show("hello","hello1");
        t.show(new String[]{"aa","bb","cc"});//这样写 也可以调用可变个数形参方法哦
    }
    public void show(String s){
        System.out.println("String::s");
    }
    public void show(String ... args){
        System.out.println("String::args");
    }

    public void show(String[] args,String s){

    }

//    public void show(String s,String...args){
//
//    }
}
