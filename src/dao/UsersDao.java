package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UsersDao {

	private static Connection conn;
    private static User user = new User();
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static User getUser(int id) throws SQLException {

    	//DBConnectionからデータベースへの接続を得る
    	conn = DBConnection.getConnection();

    	//SQLステートメント、オブジェクトの作成
    	String sql = "select * from users where id=?";
    	ps = conn.prepareStatement(sql);
    	ps.setInt(1, id);

    	//結果の出力
    	rs = ps.executeQuery();
    	while (rs.next()) {
    		user.setId(rs.getInt("id"));
    		user.setName(rs.getString("name"));
    		user.setPassword(rs.getString("password"));
    		return user;
    	}
    	return null;
    }
}
