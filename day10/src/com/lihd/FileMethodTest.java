package com.lihd;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 20:31
 */
public class FileMethodTest {
    /**
     * Test01 :  File类的获取功能
     *  public String getAbsolutePath()： 获取绝对路径
     *  public String getPath() ： 获取路径
     *  public String getName() ： 获取名称
     *  public String getParent()： 获取上层文件目录路径。 若无， 返回null
     *  public long length() ： 获取文件长度（即：字节数） 。 不能获取目录的长度。
     *  public long lastModified() ： 获取最后一次的修改时间， 毫秒值

     *
     * 如果文件不存在，方法返回的只是默认值，并不会报错
     */
    @Test
    public void test01() {
        //切换file 来观察输出结果
        File file;
        file = new File("hello.txt");
        file = new File("FileTest.txt");
        file = new File("D:/IO/a.txt");
        file = new File("D:/IO/b.txt");

        File absoluteFile = file.getAbsoluteFile();
        String path = file.getPath();
        String name = file.getName();
        String parent = file.getParent();
        long length = file.length();
        long lastModified = file.lastModified();

        System.out.println("absoluteFile = " + absoluteFile);
        System.out.println("path = " + path);
        System.out.println("name = " + name);
        System.out.println("parent = " + parent);
        System.out.println("length = " + length);
        System.out.println("lastModified = " + lastModified);
    }


    /**
     * Test02 :  File类的判断功能
     *  public boolean isDirectory()： 判断是否是文件目录
     *  public boolean isFile() ： 判断是否是文件
     *  public boolean exists() ： 判断是否存在
     *  public boolean canRead() ： 判断是否可读
     *  public boolean canWrite() ： 判断是否可写
     *  public boolean isHidden() ： 判断是否隐藏
     *
     *
     */
    @Test
    public void test02 (){
        File file;
        file = new File("D:/IO/b.txt");
        file = new File("D:/IO/a.txt");
        file = new File("hello.txt");
        file = new File("FileTest.txt");

        boolean exists = file.exists();
        boolean directory = file.isDirectory();
        boolean isFile = file.isFile();
        boolean canRead = file.canRead();
        boolean canWrite = file.canWrite();
        boolean hidden = file.isHidden();
        boolean absolute = file.isAbsolute();

        System.out.println("exists = " + exists);
        System.out.println("directory = " + directory);
        System.out.println("isFile = " + isFile);
        System.out.println("canRead = " + canRead);
        System.out.println("canWrite = " + canWrite);
        System.out.println("hidden = " + hidden);
        System.out.println("absolute = " + absolute);
    }

    /**
     * Test03 :
     *  File类的创建功能
     *       public boolean createNewFile() ： 创建文件。 若文件存在， 则不创建， 返回false
     *       public boolean mkdir() ： 创建文件目录。 如果此文件目录存在， 就不创建了。如果此文件目录的上层目录不存在， 也不创建。
     *       public boolean mkdirs() ： 创建文件目录。 如果上层文件目录不存在， 一并创建注意事项：
     *              如果你创建文件或者文件目录没有写盘符路径， 那么， 默认在项目路径下。
     *  File类的删除功能
     *       public boolean delete()： 删除文件或者文件夹删除注意事项：
     *                  Java中的删除不走回收站。要删除一个文件目录， 请注意该文件目录内不能包含文件或者文件目录
     *
     *
     */
    @Test
    public void test03 () throws Exception{
        File file = new File("src/com/lihd/a.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else {
            file.delete();
            System.out.println("创建失败");
        }

        File f1 = new File("src/com/lihd/a/a/a");
        File f2 = new File("src/com/lihd/b");

        System.out.println(f1.mkdir());
        System.out.println(f1.mkdirs());
        System.out.println(f2.mkdir());
        System.out.println(f2.mkdirs());

    }

    /**
     * Test04 :
     *  File类的重命名功能
     *  public boolean renameTo(File dest):把文件重命名为指定的文件路径
     * a.renameTo(b)
     * 要求a存在，b不存在
     * 似乎更像是文件的移动
     *
     */
    @Test
    public void test04 (){
        File file = new File("src/com/lihd/b.txt");
        System.out.println(file.renameTo(new File("D:\\IO\\b.txt")));
    }

    /**
     * Test05 :
     *  public String[] list() ： 获取指定目录下的所有文件或者文件目录的名称数组
     *  public File[] listFiles() ： 获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test05 (){
        String path = "D:\\CodeWorkspace\\JavaWorkspace\\JavaSE\\JavaSECoding\\";
        File file = new File(path);
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        Iterator<File> iterator = Arrays.stream(files).iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
