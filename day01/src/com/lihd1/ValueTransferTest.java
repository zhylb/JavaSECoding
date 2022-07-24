package com.lihd1;


/**
 * 理解java中的值传递机制
 * 如果数据是基本数据变量 那么保存的是数据值
 * 如果数据是引用数据变量 那么保存的是地址值
 *
 * 值传递
 * 如果传入的参数是基本数据变量 传入的是真实的数据值
 * 如果传入的参数是引用数据变量 传入的是变量的地址值
 *
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 15:27
 */
public class ValueTransferTest {

    public static void main(String[] args) {
        ValueTransferTest t = new ValueTransferTest();

        System.out.println("-------------------");
        t.one();

        //答案 30 2/ 25 1
        //错误1 : 30 2/ 30 1
        //错误2 : 30 2/ 20 1

        //牢记 值传递 传递地址值 或实际值
        // 在one中 v.v = 20 ,i = 1
        // 在two中 v.v = 25 ,值已经改变 i = 2
        // 在two中 v = vv 此时 v.v = 30 因为v指向了新的对象
        // 在one中 由于v.v 被改成25此时 v.v = 25 , i = 1




        System.out.println("-------------------");
        t.show();


    }

    public void one(){
        Value v = new Value();
        v.v = 20;

        int i = 1;
        two(v,i);
        System.out.println("v.v = " + v.v + ", i = " + i);

    }

    public void two(Value v, int i){
        i = 2;
        v.v = 25;

        Value vv = new Value();
        vv.v = 30;
        v = vv;

        System.out.println("v.v = " + v.v + ", i = " + i);


    }

    public void show(){
        //  如果数据是基本数据变量 那么保存的是数据值
        //  如果数据是引用数据变量 那么保存的是地址值
        int m = 10;
        int n = m;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        n = 20;
        System.out.println("m = " + m);
        System.out.println("n = " + n);

        Value v = new Value();
        Value x = v;
        System.out.println("v.v = " + v.v);
        System.out.println("x.v = " + x.v);
        x.v = 100;
        System.out.println("v.v = " + v.v);
        System.out.println("x.v = " + x.v);
    }

}

class Value{
    int v = 15;
}
