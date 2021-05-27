package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Question;

public class QuestionsDao {

	private static ArrayList<Question> qlist = new ArrayList<Question>();

	private static Connection con;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public QuestionsDao() throws Exception {
		DBConnection.getConnect();
    }

    /**
	 * 全件取得
	 */
    public List<Question> findAll() throws Exception {

    	con = DBConnection.getConnect();

    	String sql = "select * from questions";
    	ps = con.prepareStatement(sql);
    	rs = ps.executeQuery();

    	while (rs.next()) {
    		int id = rs.getInt("id");
    		String question = rs.getString("question");

    		Question bean = new Question(id, question);
    		qlist.add(bean);
    	}

    	if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

    	return qlist;
    }

    /**
	 * 新規作成
	 */
	public void create(Question q) throws Exception {
		con = DBConnection.getConnect();

		String sql = "insert into questions (question) values (?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, q.getQuestion());
		ps.executeUpdate();

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
	}

	/**
	 * idが一致するquestionを取得
	 */
	public Question findById(int id) throws Exception {
		con = DBConnection.getConnect();

		String sql = "select question FROM questions WHERE id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		Question q = new Question();
		while (rs.next()) {
			String question = rs.getString("question");
			q.setQuestion(question);
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return q;
	}

	/**
	 * 削除
	 */
	public void delete(int id) throws Exception {
		con = DBConnection.getConnect();

		String sql = "delete from questions WHERE id = ?";

		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
	}
}
