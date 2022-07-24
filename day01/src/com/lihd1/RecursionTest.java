package com.lihd1;

/**
 * 递归必须有终止 条件 否则栈溢出
 * 1 尾递归转换为循环
 * 将问题原子化
 *
 *
 * 汉诺塔问题
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 16:21
 */
public class RecursionTest {

    public static void main(String[] args) {
        show("A","B","C",3);
    }

    //从src 移动到 des 通过 temp , n 表示层数
    public static void show(String src, String des, String temp, int n){
        if(n == 1){
            work(src, des);
        }else {
            show(src,temp,des,n-1);
            work(src,des);
            show(temp,des,src,n-1);
        }
    }

    public static void work(String a, String b){
        System.out.println(a + " ---> " + b);
    }


}
