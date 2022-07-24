package com.lihd4;

/**
 * Object是所有的类的根父类
 * 如果一个类没有指定一个类的父类, 则默认父类是 java.lang.Object
 * Object中的属性具有通用性 (没有属性)
 *
 * 所有的方法
 *      1 protected native Object clone() throws CloneNotSupportedException;
 *      2 public boolean equals(Object obj)
 *      3 protected void finalize() throws Throwable { }
 *      4 public final native Class<?> getClass();
 *      5 public native int hashCode();
 *      6 public String toString()
 *      7 notify()
 *      8 notifyAll()
 *      9 wait()
 *      10 wait(long)
 *      11 wait(long, int)
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 15:34
 */
public class ObjectTest {
    public static void main(String[] args) {
        Object n = null;
    }

}
