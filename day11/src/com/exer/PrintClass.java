package com.exer;

import com.lihd1.Son;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * 通过反射打印一个类的所有信息
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 21:33
 */
public class PrintClass {
    Class clazz ;
    //构造器
    public PrintClass(String className){
        try {
            this.clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void print(){
        printPackage();
        printHead();
        System.out.println("\t//下面是属性 \n\n");
        printFields();
        System.out.println("\t//下面是构造器 \n\n");
        printConstructors();
        System.out.println("\t//下面是方法 \n\n");
        printMethods();
    }

    //1获取包
    private void printPackage(){
        Package aPackage = clazz.getPackage();
        System.out.println("package " + aPackage.getName() + ";");
    }

    //2打印类名，继承，实现的接口
    private void printHead(){
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


        int modifiers = clazz.getModifiers();
        String s = Modifier.toString(modifiers);
        String simpleName = clazz.getSimpleName();
        System.out.print(s + " class " + simpleName + " ");
        //继承信息
        Class superclass = clazz.getSuperclass();
        if(superclass != Object.class){
            System.out.print(" extends " + superclass.getSimpleName());
            printSuperGenericClass();
        }
        //打印接口
        printGenericInterfaces();
        System.out.println("{");
    }
    //3 打印属性
    private void printFields(){
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.print("\t");
            int modifiers = field.getModifiers();
            String modifierString = Modifier.toString(modifiers);
            System.out.print(modifierString + "\t");

            Class<?> type = field.getType();


                String typeName = type.getSimpleName();
                System.out.print(typeName+ "\t");



            String name = field.getName();
            System.out.print(name + ";");

            System.out.println();
        }
    }

    private void printMethods(){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.print("\t");
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
            String returnTypeName = returnType.getSimpleName();
            System.out.print(returnTypeName + "\t");

            //4 获取方法名称
            String name = method.getName();
            System.out.print(name + "(");

            //5 获取参数列表


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
                        //System.out.print(typeName);
                        printSimpleName(typeName);
                    }else {
                        printSimpleName(typeName);
                        System.out.print(", ");


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


            System.out.println(";");
        }
    }
    //打印构造器
    private void printConstructors(){
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            System.out.print("\t");
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
    private void printClass(){
//        clazz.

    }
    private void printSuperGenericClass(){

        Type genericSuperclass = clazz.getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){

            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.print("<");
            printActualTypeArguments(actualTypeArguments);
        }
    }

    private void printGenericInterfaces(){
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        if(genericInterfaces.length == 0) return;
        System.out.print("implements ");

        for (int j = 0; j < genericInterfaces.length; j++) {

            Type type = genericInterfaces[j];
            if(type instanceof ParameterizedType){

                //如果带泛型
                ParameterizedType parameterizedType = (ParameterizedType) type;
                printSimpleName(type.getTypeName());
                System.out.print("<");
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                printActualTypeArguments(actualTypeArguments);
            }else {
                //如果没有带泛型
                printSimpleName(type.getTypeName());
            }
            if(j == genericInterfaces.length - 1){
                System.out.print(" ");
            }else {
                System.out.print(", ");
            }
        }
    }

    private void printSimpleName(String name){
        String[] split = name.split("<");
        String[] split1 = split[0].split("\\.");
        System.out.print(split1[split1.length - 1]);

    }

    private void printActualTypeArguments(Type[] actualTypeArguments){
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type type = actualTypeArguments[i];
            //Class c = (Class) actualTypeArguments[i];
            if(i == actualTypeArguments.length - 1){
                printSimpleName(type.getTypeName());
                System.out.print("> ");
            }else {
                printSimpleName(type.getTypeName());
                System.out.print(",");
            }
        }
    }

}
