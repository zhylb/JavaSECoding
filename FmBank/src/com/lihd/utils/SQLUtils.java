package com.lihd.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author lihd1851053336@qq.com
 * @Date 2020/9/5 0005 10:41
 * @Since version-1.0
 */

public class SQLUtils {

    //获取Connection
    public static Connection getConnection(String srcFile) throws Exception{
        InputStream is;
        is = SQLUtils.class.getClassLoader().getResourceAsStream(srcFile);
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String driver = pros.getProperty("driver");
        String url = pros.getProperty("url");
        //2 加载驱动
        Class<?> aClass = Class.forName(driver);
        Driver d = (Driver) aClass.newInstance();
        //3 获取连接
        return DriverManager.getConnection(url, user, password);
    }
    //资源的关闭
    public static void colseResource(Connection connection,PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //资源的关闭
    public static void colseResource(Connection connection,PreparedStatement ps,ResultSet resultSet){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //通用的增删改操作
    public static int update(String srcFile,String sql,Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1 获取连接
            connection = getConnection(srcFile);
            //2 执行操作
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //ps.execute();
            return ps.executeUpdate();//比上面多一个返回值
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3 关闭资源
            colseResource(connection,ps);
        }
        return 0;
    }
    public static int update(Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        try {
            //2 执行操作
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //ps.execute();
            return ps.executeUpdate();//比上面多一个返回值
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3 关闭资源
            colseResource(null,ps);
        }
        return 0;
    }
    //需要好好理解orm编程思想
    public static <T> List<T> queryForAll(Class<T> clazz, String sql, Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = SQLUtils.getConnection("jdbc.properties");
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData data = resultSet.getMetaData();
            int count = data.getColumnCount();
            List<T> list = new ArrayList<>();
            while(resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    //String columnName = data.getColumnName(i + 1); 查询列名 无法查询别名 不建议
                    //获取标签名(可以获取别名) 没有别名时起作用就是查询列名
                    String columnLabel = data.getColumnLabel(i + 1);
                    Object o = resultSet.getObject(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,o);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLUtils.colseResource(connection,ps,resultSet);
        }
        System.out.println("返回了空");
        return null;

    }
    // 查找操作
    public static <T> List<T> queryForAll(Connection connection,Class<T> clazz, String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData data = resultSet.getMetaData();
            int count = data.getColumnCount();
            List<T> list = new ArrayList<>();
            while(resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    //String columnName = data.getColumnName(i + 1); 查询列名 无法查询别名 不建议
                    //获取标签名(可以获取别名) 没有别名时起作用就是查询列名
                    String columnLabel = data.getColumnLabel(i + 1);
                    Object o = resultSet.getObject(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,o);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLUtils.colseResource(null,ps,resultSet);
        }
        return null;
    }

    public  static <T> T queryForOne(Class<T> clazz, String sql, Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = SQLUtils.getConnection("jdbc.properties");
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData data = resultSet.getMetaData();
            int count = data.getColumnCount();


            T t = clazz.newInstance();
            for (int i = 0; i < count; i++) {
                //String columnName = data.getColumnName(i + 1); 查询列名 无法查询别名 不建议
                //获取标签名(可以获取别名) 没有别名时起作用就是查询列名
                String columnLabel = data.getColumnLabel(i + 1);
                Object o = resultSet.getObject(i + 1);

                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t,o);
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLUtils.colseResource(connection,ps,resultSet);
        }
        return null;

    }
}
