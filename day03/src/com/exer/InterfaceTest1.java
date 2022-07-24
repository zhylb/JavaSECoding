package com.exer;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 16:26
 */
public class InterfaceTest1 extends A implements B{
    public void show(){
        // System.out.println(x); 报错 因为模棱两可

        // System.out.println(this.x);报错 因为模棱两可

        System.out.println(super.x);
        System.out.println(B.x);
    }

    public static void main(String[] args) {
        InterfaceTest1 interfaceTest1 = new InterfaceTest1();
        interfaceTest1.show();
    }

}
class A{
    int x = 1;
}

interface B{
    int x = 2;
}



