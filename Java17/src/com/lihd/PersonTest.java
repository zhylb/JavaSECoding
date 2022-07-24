package com.lihd;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 8:51
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();

        record PersonRecord(String name, int age){
            @Override
            public String toString() {
                return "PersonRecord{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        PersonRecord r1 = new PersonRecord("小华",18);
        PersonRecord r2 = new PersonRecord("吕布",75);

        System.out.println(r1);
        System.out.println(r2);

    }

}

class Person{
    private String name;
    private int age;
}
