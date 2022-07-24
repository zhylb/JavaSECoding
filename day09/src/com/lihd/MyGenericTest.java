package com.lihd;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 自定义泛型要求
 *
 * 1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下： public GenericClass(){}。而下面是错误的： public GenericClass<E>(){}
 * 3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 * 4. 泛型不同的引用不能相互赋值。
 *          >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有
 *          一个ArrayList被加载到JVM中。
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。 经验： 泛型要使用一路都用。要不用，一路都不要用。
 * 6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 * 7. jdk1.7，泛型的简化操作： ArrayList<Fruit> flist = new ArrayList<>();
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * 9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。
 *          但在静态方法中不能使用类的泛型。
 * 10. 异常类不能是泛型的
 * 11. 不能使用new E[]。但是可以： E[] elements = (E[])new Object[capacity];
 *          参考： ArrayList源码中声明： Object[] elementData， 而非泛型参数类型数组。
 * 12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
 *           子类不保留父类的泛型：按需实现
 *               没有类型 擦除
 *               具体类型
 *           子类保留父类的泛型：泛型子类
 *               全部保留
 *               部分保留
 *      结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 15:41
 */
public class MyGenericTest {

    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 (){
        //1 多个泛型参数放在<>内，用","隔开
        class AA<A,B,C,D,E>{
            //22 构造器中无需写泛型
            AA(){

            }
        }

        //4 泛型不同的引用无法赋值，
        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = null;
        // list1 = list2;
    }









    public static void main(String[] args) {
        MyGeneric<String> generic = new MyGeneric<>(21);
        System.out.println(generic.getArrLen());

        generic.setE("永远不要放弃啊");
        System.out.println(generic);


        //还是报错了，因为本质上确实new 的类型是 Object[]
//        String[] arr = generic.getArr();
//        arr[0] = "aa";
//        System.out.println(arr[0]);


    }
}

class MyGeneric<E>{
    E e;
    E[] arr;

    public MyGeneric(int arrlen){
        //正确初始化 泛型数组
        arr = (E[]) new Object[arrlen];
    }

    public E[] getArr() {
        return arr;
    }

    // public static void show(E e){} 静态方法

    public int getArrLen(){
        return arr.length;
    }

    public void setE(E e){
        this.e = e;
    }

    public E getE(){
        return e;
    }
    @Override
    public String toString(){
        return "这是我的藏起起来的 : " + e ;
    }
}
