package com.lihd;



/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/10 11:26
 */
public class Student extends Person{

    int id = 1002;

    public void study(){
        System.out.println("学生应该学习");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
