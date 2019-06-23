package util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: 邓宁
 * @Date: Created in 11:45 2019/6/5
 */

public class DataBaseUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    //静态代码块，预加载数据库连接信息
    static{
        Properties properties=new Properties();
        try {
            properties.load(DataBaseUtil.class.getResourceAsStream("/db.properties"));
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //连接数据库
    public static Connection getConn() {
        Connection connection=null;
        try{
            Class.forName(driver);//加载驱动程序
            connection= DriverManager.getConnection(url, username, password);//获取数据库连接
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    //关闭数据库
    public static void closeAll(ResultSet set, PreparedStatement prestat, Connection conn) {
        if(set!=null)
            try {
                set.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        if(prestat!=null)
            try {
                prestat.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //测试方法
    public static void main(String[] args) {
        System.out.println(url);
    }
}
