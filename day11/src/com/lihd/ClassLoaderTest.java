package com.lihd;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时
 * 数据结构，然后生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问
 * 入口（即引用地址）。所有需要访问和使用类数据只能通过这个Class对象。这个加载的
 * 过程需要类加载器参与。
 * 链接：将Java类的二进制代码合并到JVM的运行状态之中的过程。
 * 验证：确保加载的类信息符合JVM规范，例如：以cafe开头，没有安全方面的问题
 * 准备：正式为类变量（static）分配内存并设置类变量默认初始值的阶段，这些内存
 * 都将在方法区中进行分配。
 * 解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程。
 * 初始化：
 * 执行类构造器<clinit>()方法的过程。 类构造器<clinit>()方法是由编译期自动收集类中
 * 所有类变量的赋值动作和静态代码块中的语句合并产生的。 （类构造器是构造类信
 * 息的，不是构造该类对象的构造器） 。
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 12:30
 */
public class ClassLoaderTest {


    /**
     * Test01 :
     * 引导类加载器：用C++编写的，是JVM自带的类加载器， 负责Java平台核心库，用来装载核心类库。该加载器无法直接获取
     * 扩展类加载器：负责jre/lib/ext目录下的jar包或 –D java.ext.dirs 指定目录下的jar包装入工作库
     * 系统类加载器：负责java –classpath 或 –Djava.class.path所指的目录下的类与jar包装入工作 ，是最常用的加载器
     *
     *
     */
    @Test
    public void test01 (){
        //获取系统类加载器
        Class<ClassLoaderTest> clazz = ClassLoaderTest.class;
        ClassLoader loader1 = clazz.getClassLoader();
        System.out.println(loader1);
        //系统类加载器 获取 上级 扩展类加载器
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);
        //扩展类加载器获取上级 引导类加载器，但是不可见，所以返回null,不代表没有
        ClassLoader loader3 = loader2.getParent();
        System.out.println(loader3);
        //4 String是核心类库，使用引导类加载器
        ClassLoader loader4 = String.class.getClassLoader();
        System.out.println(loader4);
    }

    /**
     * Test02 : 通过ClassLoader获取Stream
     * 路径位于 module/src
     *
     * 建议把配置文件放置在 src/下 而不是module下，因此使用Classloader会很方便
     */
    @Test
    public void test02 () throws IOException {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        //方式一 使用ClassLoder
        InputStream is = loader.getResourceAsStream("jdbc.properties");
        //方式二 使用FileInputStream 注意两者的路径差别
        FileInputStream fis = new FileInputStream("src/jdbc.properties");
        Properties properties = new Properties();
        //这个方法必须有，可以通过打开下面的注释来进行切换
        properties.load(is);
        //properties.load(fis);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);


    }




}
