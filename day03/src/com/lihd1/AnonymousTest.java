package com.lihd1;

/**
 * 匿名对象 与 匿名类
 * 匿名的作用 : 减少名称的命名, 便于使用
 *
 * 匿名类 : 是抽象类没有名称
 * 匿名对象 : 是对象没有名称
 *
 * 匿名类声明方法
 *      一定要记住后面的分号
 *      抽象类 对象名 = new 抽象类(){ // 重写的方法 } ;
 *
 * 匿名对象匿名类
 *      不要忘记 抽象类后面的小括号哦 (构造器)
 *      other.方法( new 抽象类(){ //重写一下} )
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 10:34
 */
public class AnonymousTest {

    public static void main(String[] args) {
        // 非匿名类, 非匿名对象
        Son son = new Son();
        display(son);

        // 非匿名类, 匿名对象
        display(new Son() );

        // 匿名类, 非匿名对象

        Base base = new Base(){

            @Override
            public void show() {
                System.out.println("匿名类 非匿名对象");
            }
        };
        display(base);

        //匿名类, 匿名对象

        display(new Base() {
            @Override
            public void show() {
                System.out.println("匿名类, 匿名对象");
            }
        });


    }


    public static void display(Base base){
        base.show();
    }
}
abstract class Base{
    public abstract void show();
}

class Son extends Base{

    @Override
    public void show() {
        System.out.println("Base::show");
    }
}
