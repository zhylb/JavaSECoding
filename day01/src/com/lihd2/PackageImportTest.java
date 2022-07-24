//这里写一行注释应该没事吧 package是第一行代码就行
package com.lihd2;


import java.util.*;// 导入java.util下的所有类

import static java.lang.Math.*;//导入Math类中的所有静态结构
import static java.lang.System.*; //导入System类中所有静态结构

/**
 * Package :
 *      1 为了更好的实现对项目中类的管理, 引入了包的概念
 *      2 使用package声明类或接口所属的包, 声明在源文件首行(不一定是第一行)
 *      3 包,标识符, 满足"xxxyyyzzz",见名知意
 *      4 每 "." 一次, 代表一次目录
 *      5 同一包下不可以定义同名的类或接口, 不同包下可以
 *
 * Import :
 *      1 在源文件中使用import导入想要使用的接口或者类
 *      2 声明在 包的声明和类的声明之间
 *      3 如果需要导入多个包, 并列导入即可
 *      4 使用 "xxx.*" 表示导入包下所有的类
 *      5 如果使用的类是 java.lang 包下的类 , 可以省略import
 *      6 如果使用的类是本包下的类, 可以省略import
 *      7 如果使用了不同包下的同名的类, 在没有导入包的类前面加上全类名 "java.sql.Date"
 *      8 如果导入了一个包下的所有类, 如果要使用这个包子包下的类, 仍需要导入
 *
 *      9 可以使用 import static 导入一个类中所有的静态属性和静态方法
 *
 * 常用的包
 *      1. java.lang----包含一些Java语言的核心类， 如String、 Math、 Integer、 System和Thread， 提供常用功能
 *      2. java.net----包含执行与网络相关的操作的类和接口。
 *      3. java.io ----包含能提供多种输入/输出功能的类。
 *      4. java.util----包含一些实用工具类， 如定义系统特性、 接口的集合框架类、 使用与日期日历相关的函数。
 *      5. java.text----包含了一些java格式化相关的类
 *      6. java.sql----包含了java进行JDBC数据库编程的相关类/接口
 *      7. java.awt----包含了构成抽象窗口工具集（abstract window toolkits） 的多个类， 这些类被用来构建和管理应用程序的图形用户界面(GUI)。 B/S C/S
 * awt中的类可以不用学习
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/10 10:21
 */
public class PackageImportTest {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        HashMap m = new HashMap();

        int a = abs(-8);

        out.println("省略了System.");

        Date d = new Date();
        //如果使用了不同包下的同名的类, 至少一个类使用全类名
        java.sql.Date date = new java.sql.Date(2387593839L);



    }

}
