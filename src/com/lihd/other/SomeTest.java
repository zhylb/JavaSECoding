package com.lihd.other;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/21 21:20
 */
public class SomeTest {

    public static void main(String[] args) {
        //书上的例子 验证结果无误
        //Integer[] arr = {55,58,39,18,90,160,150,38,184};
        //下面是习题
        Integer[] arr = {27,129,110,186,147,41,10,64,120};

        fifo(arr,100);
        sstf(arr,100);
        scan(arr,100,false);
        cScan(arr,100,false);
        scan(arr,100,true);
        cScan(arr,100,true);
    }

    public static void fifo(Integer[] arr, int previous){
        System.out.println("FIFO");
        System.out.println("下一个被访问磁道\t\t横跨的磁道数");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]+"\t\t\t\t\t");
            int across = Math.abs(previous - arr[i]);
            System.out.println(across);
            previous = arr[i];
            sum += across;
        }
        double aver = (sum + 0.0)/ arr.length;
        System.out.printf("平均寻道长度 ：%4.1f\n", aver);
    }
    public static void sstf(Integer[] a, int previous){

        Integer[] arr  = Arrays.copyOf(a, a.length);
        System.out.println("SSTF");
        System.out.println("下一个被访问磁道\t\t横跨的磁道数");
        int sum = 0;
        //好像要两层循环 复杂度n方有点高 感觉可以优化
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]!=-1){
                    int now = Math.abs(previous - arr[j]);
                    if(now < min){
                        //长度循环 找到最小的
                        min = now;//记录值
                        minIndex = j;//记录下标
                    }
                }
            }
            //循环结束 将下一个值赋值为 -1 在此之前获取值
            previous = arr[minIndex];
            arr[minIndex] = -1;
            //打印即可
            System.out.print(previous+"\t\t\t\t\t");
            System.out.println(min);
            sum += min;
        }
        double aver = (sum + 0.0)/ arr.length;
        System.out.printf("平均寻道长度 ：%4.1f\n", aver);

    }

    public static void scan(Integer[] a, int previous,boolean largen){

        Integer[] arr = Arrays.copyOf(a, a.length);
        System.out.println("SCAN");
        System.out.println("下一个被访问磁道\t\t横跨的磁道数");
        int sum = 0;
        if(!largen){
            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1,o2);
                }
            });
        }else {
            Arrays.sort(arr);
        }

        int first = 0;
        for (int i = 0; i < arr.length; i++) {
            if(largen&&arr[i] >= previous){
                first = i;
                break;
            }

            if(!largen&&arr[i]<=previous){
                first = i;
                break;
            }
        }

        for (int i = first; i < arr.length; i++) {
            System.out.print(arr[i]+"\t\t\t\t\t");
            int across = Math.abs(previous - arr[i]);
            System.out.println(across);
            previous = arr[i];
            sum += across;
        }

        for (int i = first - 1; i >= 0; i--) {
            System.out.print(arr[i]+"\t\t\t\t\t");
            int across = Math.abs(previous - arr[i]);
            System.out.println(across);
            previous = arr[i];
            sum += across;
        }
        double aver = (sum + 0.0)/ arr.length;
        System.out.printf("平均寻道长度 ：%4.1f\n", aver);
    }

    public static void cScan(Integer[] a, int previous, boolean largen){
        Integer[] arr = Arrays.copyOf(a, a.length);
        System.out.println("C-SCAN");
        System.out.println("下一个被访问磁道\t\t横跨的磁道数");

        int sum = 0;
        if(!largen){
            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1,o2);
                }
            });
        }else {
            Arrays.sort(arr);
        }

        int first = 0;
        for (int i = 0; i < arr.length; i++) {
            if(largen&&arr[i] >= previous){
                first = i;
                break;
            }

            if(!largen&&arr[i]<=previous){
                first = i;
                break;
            }
        }

        for (int i = first; i < arr.length; i++) {
            System.out.print(arr[i]+"\t\t\t\t\t");
            int across = Math.abs(previous - arr[i]);
            System.out.println(across);
            previous = arr[i];
            sum += across;
        }

        for (int i = 0; i < first; i++) {
            System.out.print(arr[i]+"\t\t\t\t\t");
            int across = Math.abs(previous - arr[i]);
            System.out.println(across);
            previous = arr[i];
            sum += across;
        }
        double aver = (sum + 0.0)/ arr.length;
        System.out.printf("平均寻道长度 ：%4.1f\n", aver);
    }
}
