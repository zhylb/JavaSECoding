package com.lihd;

import org.junit.Test;

import java.util.Locale;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/9 9:35
 */
public class StringMethodTest {
    /**
     * Test01 : String中的常用方法
     *  int length()： 返回字符串的长度： return value.length
     *  char charAt(int index)： 返回某索引处的字符return value[index]
     *  boolean isEmpty()： 判断是否是空字符串： return value.length == 0
     *  String toLowerCase()： 使用默认语言环境， 将 String 中的所有字符转换为小写
     *  String toUpperCase()： 使用默认语言环境， 将 String 中的所有字符转换为大写
     *  String trim()： 返回字符串的副本， 忽略前导空白和尾部空白,只能去掉半角
     *  String strip()： 返回字符串的副本， 忽略前导空白和尾部空白，可以去掉半角和全角 since java11
     *  boolean equals(Object obj)： 比较字符串的内容是否相同
     *  boolean equalsIgnoreCase(String anotherString)： 与equals方法类似， 忽略大小写
     *  String concat(String str)： 将指定字符串连接到此字符串的结尾。 等价于用“+”
     *  int compareTo(String anotherString)： 比较两个字符串的大小
     *  String substring(int beginIndex)： 返回一个新的字符串， 它是此字符串的从
     * beginIndex开始截取到最后的一个子字符串。
     *  String substring(int beginIndex, int endIndex) ： 返回一个新字符串， 它是此字
     * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     */
    @Test
    public void test01 (){
        String s = "零一二三四五";
        //length() 返回字符串长度，但是字符个数而不是byte[]长度
        System.out.println(s.length());
        //返回某个位置的值 超过会报StringIndexOutOfBoundsExcception
        System.out.println(s.charAt(2));
        //isEmpty()  retrun value.length == 0
        System.out.println(s.isEmpty());
        //toLowerCase() toUpperCase(); 似乎还可以传入参数Locale
        s = "HelloWorld";
        System.out.println(s.toLowerCase(Locale.ROOT));
        System.out.println(s.toUpperCase());

        //trim() 其中\u2000是Unicode中的空白，全角空白，观察下面的输出结果，由结果可以看出建议使用strip（）
        s = "  \u2000What the fuck\u2000  ";
        System.out.println("----"+s.trim()+"----");
        System.out.println("----"+s.strip()+"----");

        //equals equalsIgnoreCase
        s = "Lover";
        System.out.println(s.equals("lover"));//false
        System.out.println(s.equalsIgnoreCase("lover"));//true

        //concat 与 + concat等价于 +
        System.out.println(s.concat("Dream"));
        System.out.println(s + "Dream");

        //compareTo比较大小，直接相减，结果可能是整数
        System.out.println("abcd".compareTo("abz"));//-23(z - c) 代表abcd < abz


        //subString
        s = "0123456789";
        System.out.println(s.substring(4));
        System.out.println(s.substring(3,8));// [3,8) 左闭右开
    }

    /**
     * Test02 :
     *  boolean endsWith(String suffix)： 测试此字符串是否以指定的后缀结束
     *  boolean startsWith(String prefix)： 测试此字符串是否以指定的前缀开始
     *  boolean startsWith(String prefix, int toffset)： 测试此字符串从指定索引开始的
     * 子字符串是否以指定前缀开始
     *
     *  boolean contains(CharSequence s)： 当且仅当此字符串包含指定的 char 值序列时，返回 true
     *  int indexOf(String str)： 返回指定子字符串在此字符串中第一次出现处的索引
     *  int indexOf(String str, int fromIndex)： 返回指定子字符串在此字符串中第一次出
     * 现处的索引，从指定的索引开始
     *  int lastIndexOf(String str)： 返回指定子字符串在此字符串中最右边出现处的索引
     *  int lastIndexOf(String str, int fromIndex)： 返回指定子字符串在此字符串中最后
     * 一次出现处的索引，从指定的索引开始反向搜索
     * 注： indexOf和lastIndexOf方法如果未找到都是返回-1
     *
     */
    @Test
    public void test02 (){
        //xxxWith()
        String s = "0123456789";
        System.out.println(s.startsWith("0123"));//true
        System.out.println(s.endsWith("6789"));//true
        System.out.println(s.startsWith("45", 4));//true
        System.out.println(s.startsWith("45", 5));//false

        //contains() indexOf lastIndexOf
        s = "aabbaabababa";
        System.out.println(s.contains("aba"));//true

        System.out.println(s.indexOf("c"));//-1 找不到返回-1
        System.out.println(s.indexOf("aba"));//5
        System.out.println(s.indexOf("aba", 6));//7


        System.out.println(s.lastIndexOf("aba"));//9
        System.out.println(s.lastIndexOf("aba",6));//5

        //问题一 什么时候indexOf 和lastIndexOf方法返回的值相同
        //1 只含有一个目标
        //2 没有包含目标值 结果都是-1

        //问题二 请设计一个可以找到有多少个子串的方法，并输出所有位置的数组（返回值）
        //请见 exer中 StringUtils

    }

    /**
     * Test03 :
     *  String replace(char oldChar, char newChar)： 返回一个新的字符串， 它是
     * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     *  String replace(CharSequence target, CharSequence replacement)： 使
     * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     *
     *
     */
    @Test
    public void test03 (){
        String s = "abaabbbaaab";
        System.out.println(s.replace('a','c'));
        System.out.println(s.replace("ab", "ee"));


    }


    /**
     * Test04 : 有关正则表达式的字符串操作，希望你日后可以看见我2022年3月9日10:09:24
     *
     *  String replaceAll(String regex, String replacement) ： 使 用 给 定 的
     * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     *  String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
     * *replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     *
     *  boolean matches(String regex)： 告知此字符串是否匹配给定的正则表达式。
     *
     *  String[] split(String regex)： 根据给定正则表达式的匹配拆分此字符串。
     *  String[] split(String regex, int limit)： 根据匹配给定的正则表达式来拆分此
     * 字符串， 最多不超过limit个， 如果超过了， 剩下的全部都放到最后一个元素中。
     *
     *
     */
    @Test
    public void test04 (){
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        //--------------------------------------------------------------
        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        System.out.println("-------------------split------------------");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}
