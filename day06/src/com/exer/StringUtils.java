package com.exer;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/9 10:06
 */
public class StringUtils {

    public static void main(String[] args) {
        String s = "abbabababaabaababab";
        String sub = "abb";
        getSubstringIndexList(s,sub).stream().forEach(System.out::println);
    }

    public static List<Integer> getSubstringIndexList(String str,String sub){
        ArrayList<Integer> list = new ArrayList<>();
        int len = str.length();
        int index = 0;
        int a = -2;
        while (index < len && a != -1){
            if(a == -2){
                a = str.indexOf(sub,index);
            }else {
                a = str.indexOf(sub,index + sub.length());
            }
            index += a;
            list.add(a);
        }
        list.remove(new Integer(-1));
        return list;
    }
}
