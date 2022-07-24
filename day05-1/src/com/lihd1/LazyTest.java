package com.lihd1;

/**
 * 懒汉式 线程安全版本
 * 使用 synchronized 即可
 * 1*2*3 = 1+2+3
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 17:29
 */
public class LazyTest {
    public static void main(String[] args) {
        Lazy l1 = Lazy.getLazy();
        Lazy l2 = Lazy.getLazy();
        System.out.println(l1 == l2);//true 确实是一个对象
    }
}

class Lazy{
    private Lazy(){

    }
    private static Lazy lazy;
    //下面这种方式效率不高，因为前面说了，不能多也不能少

//    public synchronized static Lazy getLazy(){
//        if (lazy == null) {
//            lazy = new Lazy();
//        }
//        return lazy;
//    }
    //这种效率比较高
    public static Lazy getLazy(){
        if (lazy == null) {
            synchronized (Lazy.class){
                if(lazy == null){
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }

}