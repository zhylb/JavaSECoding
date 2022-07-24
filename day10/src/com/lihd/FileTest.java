package com.lihd;

import org.junit.Test;

import java.io.File;

/**
 * 1 File : 文件和文件目录的抽象描述方式，与操作系统无关
 * 2 File类声明在 java.io 包下
 * 3 File类中涉及到文件或者文件目录的创建删除修改重命名，修改时间，文件大小等方法
 *      并未涉及到写入或读取文件的操作，如果需要读取或者写入文件内容，必须使用IO流来完成
 * 4 后续File类的对象常会作为参数传递到流的构造器中，指明读取和写出的路径
 *
 * 文件路径 ：
 *      相对路径 ：
 *          main方法 ：相对于当前工程路径下
 *          test单元测试 ：相对于当前模块路径下
 *      绝对路径 ：
 *          一个固定的路径，从盘符开始
 *
 *  路径中的每级目录之间用一个路径分隔符隔开。
 *  路径分隔符和系统有关：
 *       windows和DOS系统默认使用“\”来表示
 *       UNIX和URL使用“/”来表示
 *  Java程序支持跨平台运行，因此路径分隔符要慎用。
 *  为了解决这个隐患， File类提供了一个常量：
 *      public static final String separator。根据操作系统，动态的提供分隔符。
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 20:17
 */
public class FileTest {
    /**
     * Test01 : 实例化File
     * 三种构造器
     * File(String path);
     * File(String parent,String child);
     * File(File parent, child);
     *
     */
    @Test
    public void test01 (){
        File file = new File("hello.txt");
        File abFile = new File("D:\\CodeWorkspace\\JavaWorkspace\\JavaSE\\JavaSECoding\\day10\\src\\com\\lihd");

        System.out.println("file = " + file);
        System.out.println("abFile = " + abFile);
        File f1 = new File("D:\\CodeWorkspace","JavaWorkspace");
        File f2 = new File(f1, "JavaSECoding");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
    }
}
