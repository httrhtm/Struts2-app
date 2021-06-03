package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Question;

public class QuestionsDao {

    /**
	 * 全件取得
	 */
    public List<Question> findAll() throws Exception {

    	List<Question> qlist = new ArrayList<Question>();

		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT * FROM questions");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String question = rs.getString("question");
			Question q = new Question(id, question);
			qlist.add(q);
		}

		return qlist;

    }

    /**
	 * 新規作成
	 */
	public void create(Question q) throws Exception {
		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = conn
				.prepareStatement("insert into questions (question) values (?)");
		ps.setString(1, q.getQuestion());
		ps.executeUpdate();

		if (ps != null) {
			ps.close();
		}
	}

	/**
	 * idが一致するquestionを取得
	 */
	public Question findById(int id) throws Exception {
		Connection conn = DBConnection.getConnection();

		Question q = new Question();

		PreparedStatement ps = conn
				.prepareStatement("select question FROM questions WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

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
		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = conn
				.prepareStatement("delete from questions WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();

		if (ps != null) {
			ps.close();
		}
	}
}
