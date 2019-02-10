package dao;

import java.sql.*;

public class DBUtil {

    private static final String driverClass="com.mysql.cj.jdbc.Driver";
    private static final String Url="jdbc:mysql://localhost:3306/bookMS?serverTimezone=GMT%2B8";
    private static final String usename="root";
    private static final String usepass="root";

    /**
     * 创建数据库连接
     * @returns
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn= DriverManager.getConnection(Url,usename,usepass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接,释放资源
     * 执行查询操作的方法中使用
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt,Connection conn){
        try{
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null||!conn.isClosed()){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接,释放资源
     * 执行增删改操作的方法中使用
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        try{
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null||!conn.isClosed()){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
