package com.lihd;

/**
 * 单例模式
 * 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。
 * 为什么不设计成一个只有静态属性方法的类 : 需要外部传入值 进行某些值的初始化
 *
 *
 * 1 实现步骤
 *      1 私有化构造器
 *      2 私有化静态属性
 *      3 提供公共的静态返回方法
 *
 *
 *
 *
 *
 * 2.3 两种方式的对比：
 *     饿汉式：
 *   	坏处：对象加载时间过长。
 *   	好处：饿汉式是线程安全的
 *
 *     懒汉式：好处：延迟对象的创建。
 * 	    	  目前的写法坏处：线程不安全。--->到多线程内容时，再修改
 *
 * 3 单例模式的应用
 *
 * java.lang.Runtime 采用了 饿汉式的单例模式
 *
 * public class Runtime {
 *     private static Runtime currentRuntime = new Runtime();
 *
 * 在其他方面的应用
 *       网站的计数器，一般也是单例模式实现，否则难以同步。
 *       应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志
 *          文件一直处于打开状态，因为只能有一个实例去操作， 否则内容不好追加。
 *       数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
 *       项目中， 读取配置文件的类，一般也只有一个对象。没有必要每次使用配置
 *          文件数据，都生成一个对象去读取。
 *       Application 也是单例的典型应用
 *       Windows的Task Manager (任务管理器)就是很典型的单例模式
 *       Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程
 *          中，回收站一直维护着仅有的一个实例
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 17:51
 */
public class SingletonTest {
    public static void main(String[] args) {
        Hungry h1 = Hungry.getInstance();
        Hungry h2 = Hungry.getInstance();
        System.out.println(h1 == h2);//true

        Lazy l1 = Lazy.getInstance();
        Lazy l2 = Lazy.getInstance();
        System.out.println(l1 == l2);//true
    }

}


//饿汉式
class Hungry{

    //1 私有化构造器
    private Hungry(){

    }

    //2 私有化静态属性
    private static Hungry instance = new Hungry();

    //3 提供公共的静态方法
    public static Hungry getInstance(){
        return instance;
    }

}

//懒汉式
class Lazy{
    //1 私有化构造器
    private Lazy(){

    }

    //2 私有化静态属性
    private static Lazy instance = null;//没有创建

    //3 提供公共的静态方法
    public static Lazy getInstance(){
        //需要时 再创建 目前线程不安全
        if(instance == null){
            instance = new Lazy();
        }
        return instance;
    }
}