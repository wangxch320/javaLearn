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
            //�������ݿ����棬���ظ����ַ���������
                  Class.forName(JDriver);
              }catch(ClassNotFoundException e)
              {
               //e.printStackTrace();
                  System.out.println("�������ݿ�����ʧ��");
                  System.exit(0);
              }     
              System.out.println("���ݿ������ɹ�");
        try {
            // �������ݿ�
            conn = DriverManager.getConnection(url, "sa", "wangxch2015");
            // ����Statement����
            stmt = conn.createStatement();
            /**
             * Statement createStatement() ����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
             */
            // ִ�����ݿ��ѯ���
            rs = stmt.executeQuery(sql);
            /**
             * ResultSet executeQuery(String sql) throws SQLException ִ�и����� SQL
             * ��䣬����䷵�ص��� ResultSet ����
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
            System.out.println("���ݿ�����ʧ��");
        }
    }
}
