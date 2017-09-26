package org.crazyit.app.domain;

import java.sql.*;

public class SQLserverConnect {
	public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Panorama;";
        String sql = "select * from tb_log";
        try {
            //加载数据库引擎，返回给定字符串名的类
                  Class.forName(JDriver);
              }catch(ClassNotFoundException e)
              {
               //e.printStackTrace();
                  System.out.println("加载数据库引擎失败");
                  System.exit(0);
              }     
              System.out.println("数据库驱动成功");
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, "sa", "wangxch2015");
            // 建立Statement对象
            stmt = conn.createStatement();
            /**
             * Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
             */
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql);
            /**
             * ResultSet executeQuery(String sql) throws SQLException 执行给定的 SQL
             * 语句，该语句返回单个 ResultSet 对象
             */
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Dateline");
                System.out.println("Sno:" + id + "\tSame:" + name + "\tSage:");
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
