package com.exer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 23:38
 */
public class IOUtils {



    public static <T> List<T> getObjectList(Class<T> clazz,String srcPath){
        ArrayList<T> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(srcPath)));
            Object o;
            while((o = ois.readObject()) != null){
                list.add((T) o);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static <T> void writeObjectList(List<T> list,String desPath){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desPath)));
            for (T t : list) {
                   oos.writeObject(t);
                   oos.flush();//每一次建议要显示刷新
            }
            oos.writeObject(null);
            oos.flush();//每一次建议要显示刷新

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void copyStream(String srcFile,String desFile){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(desFile));

            int len;
            byte[] buffer = new byte[1024];
            while((len = bis.read(buffer)) != 0){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void copyCharFile(String srcFile,String desFile){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(desFile));

            int len;
            char[] cbuffer = new char[1024];

            while((len = br.read(cbuffer)) != -1){
                bw.write(cbuffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void convertCharSet(String srcFile,String srcCharset,String desFile,String desCharset){
        //别忘了加入参数，使用默认的字符集总会引起一些错误
        //new InputStreamReader(ins,String charSetName)
        //new OutputStreamWriter(ous,String charSetName)
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(srcFile))),srcCharset);
            osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(new File(desFile))),desCharset);

            int len;
            char[] cbuffer = new char[1024];

            while((len = isr.read(cbuffer)) != -1){
                osw.write(cbuffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
