package com.lihd;

/**
 * final 关键字 最终的 最后的
 * 可以修饰 属性 方法 类
 * native 关键字 : 本地的 没有方法体
 *
 * 另外 : native 关键字表示调用了本地的c , cpp方法 基础阶段不多介绍
 * native 方法不可以有 方法体
 * 1 修饰类
 *      表示类不可以被继承
 *      String, System 就被final修饰
 *      (public final class String)
 * 2 修饰方法
 *      表示方法不可以被重写 比如 Object.getClass()
 *       (public final native Class<?> getClass();)
 * 3 修饰属性 建议全部大写
 *      必须要赋值 一下三种方法必选其一
 *      1 显示赋值 : 如果是 或许可以考虑加一个static哦(不建议)
 *      2 代码赋值 : 如果有其他操作, 或者抛异常
 *      3 构造器赋值 (确保每个构造器都有赋值操作 否则报错) : 每个人的常量不一样建议采用
 *
 *
 * 4 修饰局部变量
 *      修饰基本数据类型 : 不可以改变
 *      修饰引用数据类型 : 指向的对象不可以改变 , 对象的属性可以改变
 *
 *
 * 5 static final
 *      static 可以修饰 属性 方法 代码块 内部类
 *      final 可以修饰 属性 方法 类
 *      static final 可以修饰 属性 方法
 *      1 修饰属性 : 全局常量 (接口中的量) Math.PI
 *      2 修饰方法 : 由于final修饰方法表示不可继承 而static修饰的方法不可能有重写一说
 *                  因此  一般这两个值很少同时出现
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 0:33
 */
public final class FinalTest {//类可以用final修饰

    public final int UP = 1;//显示赋值

    public final int DOWN;

    public final int LEFT;

    {
        //如果有异常只能这样
        DOWN = 1;//代码块中赋值
    }

    // 所有的构造器 必须给 left赋值 否则报错
    FinalTest(){
        LEFT = 1;
    }

    FinalTest(int left){
        LEFT = left;
    }

    public static void main(String[] args) {
        final Order o = new Order();
        // o = new Order(); 指向的对象不可以改变
        o.a++; // 对象的属性可以改变
        System.out.println(o.a);

        FinalTest ft = new FinalTest();
        // ft.show(); 定义不报错 执行会报错
    }


    public final int method1(final int a){
        // a = 2; 修改a的值 报错
        return a + 2;//正常使用 不会报错
    }

    public static final int m(){
        //idea 告诉我们 static 和 final是重复的
        //建议我们删除 final 因为静态方法根本没有重写一说
        return 1;
    }

    // 自定义 一个native 方法好像不会报错
    public native void show();

    //尝试重写final方法 报错
//    public final  Class<?> getClass(){}


}

class Order{
    int a;
}


// class subString extends String{}


