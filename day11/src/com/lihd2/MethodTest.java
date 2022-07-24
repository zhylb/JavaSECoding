package com.lihd2;

import com.lihd1.Son;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 16:23
 */
public class MethodTest {
    /**
     * Test01 :
     * getMethods() 获取本类和所有父类中声明为  public的方法
     * getDeclaredMethods() 获取本类（不包括父类）中所有的权限方法
     *
     */
    @Test
    public void test01 (){
        Class<Son> clazz = Son.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }


    /**
     * Test02 : 获取方法中的具体结构
     *
     *
     *
     */
    @Test
    public void test02 (){
        Class<Son> clazz = Son.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //1 获取注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //2 获取权限修饰符
            int modifiers = method.getModifiers();
            String modifierString = Modifier.toString(modifiers);
            System.out.print(modifierString + "\t");

            //3 获取返回值类型 包括什么synchronized,static 等
            Class<?> returnType = method.getReturnType();
            String returnTypeName = returnType.getName();
            System.out.print(returnTypeName + "\t");

            //4 获取方法名称
            String name = method.getName();
            System.out.print(name + "(");

            //5 获取参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();


//            if(parameterTypes.length > 0){
//                for (int i = 0; i < parameterTypes.length; i++) {
//                    String paraName = parameterTypes[i].getName();
//                    if(i == parameterTypes.length - 1){
//                        System.out.print(paraName);
//                    }else {
//                        System.out.print(paraName + ", ");
//                    }
//                }
//            }


            AnnotatedType[] annotatedParameterTypes = method.getAnnotatedParameterTypes();
            if(annotatedParameterTypes.length > 0){
                for (int i = 0; i < annotatedParameterTypes.length; i++) {
                    Annotation[] parAnnotation = annotatedParameterTypes[i].getAnnotations();
                    Type type = annotatedParameterTypes[i].getType();
                    String typeName = type.getTypeName();
                    for (Annotation annotation : parAnnotation) {
                        System.out.print(annotation + " ");
                    }

                    if(i == annotatedParameterTypes.length - 1){
                        System.out.print(typeName);
                    }else {
                        System.out.print(typeName + ", ");
                    }
                }
            }
            System.out.print(")");


            //6 获取异常类型
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    String s = exceptionTypes[i].getName();
                    if(i == exceptionTypes.length - 1){
                        System.out.print(s);
                    }else {
                        System.out.print(s + ", ");
                    }
                }

            }


            System.out.println("{ /**/ }");
        }
    }


}
