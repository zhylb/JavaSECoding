package com.lihd1;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/17 8:59
 */
public class Student extends Person{

    int id;

    public Student(){

    }

    public Student(int id){
        this.id = id;
    }

    public void showId(){
        System.out.println(id);
    }
    // 正常的方法重写
    public void eat(){
        System.out.println("Student::eat");
    }

    // 无法重写父类的私有方法哦
    public void say(){
        System.out.println("尝试重写父类中的私有方法");
    }


    //静态方法没有重写一说, 因此这里注定会重写失败
    //此处如果删去 static那么会立马报错, 因为必须同时static或非static
    public static void methodStatic(){
        System.out.println("尝试重写父类中的静态方法");
    }


    //此处的返回值可以是Object的子类
    @Override
    public String  method1() {
        return null;
    }

    //这里抛出的异常对象不能大于父类
    @Override
    public void method2() throws RuntimeException {
        throw new RuntimeException("抛出一个运行时异常");
    }
}
