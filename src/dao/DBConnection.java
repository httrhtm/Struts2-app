package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DBドライバのロード成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() {
        String user = "root";
        String password = "hacchan82";
        String url = "jdbc:mysql://localhost:3306/struts2_db?serverTimezone=JST";
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("DB接続成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void disConnect(Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
                System.out.println("DB接続の切断成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
