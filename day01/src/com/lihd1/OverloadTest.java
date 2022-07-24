package com.lihd1;

/**
 * 方法的重载(overload)
 *
 * 定义 : 在一个类中允许存在一个以上的同名方法, 只有他们的参数列表不同即可
 *      两同一不同 : 同一类,同名方法 , 不同参数列表
 * 举例 : Arrays.sort Math.max 都是重载方法
 *
 * 如何判断是否构成重载 :
 *      与权限修饰符, 返回值类型, 参数名称, 方法体 无关
 *      只与 方法名与参数列表有关
 * 如何通过调用自己想要调用的方法 :
 *      属性.方法(想要的参数列表) 先看方法名 后看参数列表
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 9:37
 */
public class OverloadTest {


    public static void main(String[] args) {
        OverloadTest t = new OverloadTest();
        t.getSum(2,3);//如果注释了 getSum(int a, int b)这里会打印 double a,double b 因为向上转型
        t.getSum(2.1,3);
    }


    public void getSum(int a, int b){
        System.out.println("int a, int b");
    }


//    private void getSum(int a,int b){
//        以为参数列表相同 不同的是权限修饰符, 因此不构成重载
//    }


//    public void getSum(int m, int n){
//       因为参数列表相同 不同的是参数名称, 因此不构成重载
//    }

//    public static void getSum(int a,int b){
//        只是多了一个static 也不构成重载
//    }

    public void getSum(double a, double b){
        System.out.println("double a, double b");
    }

}
