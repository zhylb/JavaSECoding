package com.lihd2;

import com.lihd1.Son;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 16:27
 */
public class OtherTest {

    /**
     * Test00 :
     *
     *
     *
     */
    @Test
    public void test00 (){
        Class<Son> clazz = Son.class;
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            int modifiers = constructor.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            String name = constructor.getDeclaringClass().getSimpleName();
            System.out.print(name + "(");

            Class[] parameterTypes = constructor.getParameterTypes();
            if(parameterTypes.length > 0){
                for (int i = 0; i < parameterTypes.length; i++) {
                    String paraName = parameterTypes[i].getSimpleName();
                    if(i == parameterTypes.length - 1){
                        System.out.print(paraName);
                    }else {
                        System.out.print(paraName + ", ");
                    }
                }
            }

            System.out.println(");");
        }
    }

    /**
     * Test01 : 获取构造器信息
     * getConstructors() 获取本类中声明为public的构造器（设计者认为拿到父类构造器没有太多实际意义）
     * getDeclaredConstructors() 获取本类中所有权限的构造器
     */
    @Test
    public void test01 (){
        Class<Son> clazz = Son.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
    }


    /**
     * Test02 : 获取带泛型父类的泛型
     * 1 获取父类
     * 2 获取带泛型父类
     * 3 获取带泛型父类的泛型
     */
    @Test
    public void test02 (){
        //1 获取父类
        Class<Son> clazz = Son.class;
        Class<? super Son> superclass = clazz.getSuperclass();
        System.out.println(superclass.getName());
        //2 获取带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());

        //3 获取带泛型父类的泛型
        System.out.println(genericSuperclass.getClass());//ParameterizedTypeImpl
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        //java.lang.String
        for (Type type : actualTypeArguments) {
            Class cl = (Class) type;
            System.out.println(cl.getName());
        }
    }


    /**
     * Test03 : 获取接口
     *
     *
     *
     */
    @Test
    public void test03 (){
        //1 获取接口
        Class<Son> clazz = Son.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class aClass : interfaces) {
            System.out.println(aClass);
        }
        //2 获取接口的泛型
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            System.out.println(type.getClass());

            if(type instanceof ParameterizedType){
                //如果带泛型
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type t : actualTypeArguments) {
                    Class cl = (Class) t;
                    System.out.println(cl.getName());
                }
            }else {
                //如果没有带泛型
                System.out.println(type.getTypeName());
            }
        }

        //获取父类的接口
        System.out.println();
        Class<? super Son> superclass = clazz.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for (Class aClass : interfaces1) {
            System.out.println(aClass);
        }
        System.out.println();
        //获取父类接口的泛型

        //省略
    }

    /**
     * Test04 : 获取包名
     *
     *
     *
     */
    @Test
    public void test04 (){
        Class<Son> clazz = Son.class;
        String packageName = clazz.getPackageName();
        System.out.println(packageName);

    }

    /**
     * Test05 : 获取类的泛型
     *
     *
     *
     */
    @Test
    public void test05 (){
        Class<Son> clazz = Son.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }




    }

}
