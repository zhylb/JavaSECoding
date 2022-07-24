package com.lihd2;

import com.lihd1.Son;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 15:46
 */
public class FieldTest {

    /**
     * Test01 :
     * getFields() 获取本类和所有父类中声明为  public的属性
     * getDeclaredFields() 获取本类（不包括父类）中所有的权限属性
     *
     *
     */
    @Test
    public void test01 (){
        Class<Son> clazz = Son.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }


    /**
     * Test02 : 获取更为具体的信息
     * 要获取什么，get什么即可
     *
     *
     */
    @Test
    public void test02 (){
        Class<Son> clazz = Son.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            int modifiers = field.getModifiers();
            String modifierString = Modifier.toString(modifiers);
            System.out.print(modifierString + "\t");

            Class<?> type = field.getType();
            String typeName = type.getName();
            System.out.print(typeName+ "\t");

            String name = field.getName();
            System.out.print(name + ";");

            System.out.println();
        }


    }

}
