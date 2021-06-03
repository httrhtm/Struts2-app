package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.CorrectAnswer;

public class CorrestAnswersDao {

    /**
     * 全件取得
     */
    public List<CorrectAnswer> findAll() throws Exception {
    	List<CorrectAnswer> calist = new ArrayList<CorrectAnswer>();

		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT * FROM correct_answers");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			CorrectAnswer ca = new CorrectAnswer(rs.getInt("id"), rs.getInt("questions_id"),
					rs.getString("answer"));
			calist.add(ca);
		}

		return calist;
    }

    /**
	 * 新規作成
	 */
	public void create(CorrectAnswer ca) throws Exception {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("insert into correct_answers (questions_id, answer) values ((select id from questions order by created_at desc limit 1), ?)");
		ps.setString(1, ca.getAnswer());
		ps.executeUpdate();

		if (ps != null) {
			ps.close();
		}
	}

	/**
	 * IDから取得
	 */
	public List<CorrectAnswer> findByQuestionsId(int questions_id) throws Exception {
		Connection conn = DBConnection.getConnection();

		List<CorrectAnswer> calist = new ArrayList<CorrectAnswer>();

		PreparedStatement ps = conn
				.prepareStatement("select id, answer from correct_answers where questions_id = ?");
		ps.setInt(1, questions_id);
		ResultSet rs = ps.executeQuery();

    	while (rs.next()) {
    		int id = rs.getInt("id");
    		String answer = rs.getString("answer");

    		CorrectAnswer ca = new CorrectAnswer(id, answer);
    		calist.add(ca);
    	}

    	if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

    	return calist;
	}

	public void delete(int questions_id) throws Exception {
		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = conn
				.prepareStatement("DELETE FROM correct_answers WHERE questions_id = ?");

		ps.setInt(1, questions_id);
		ps.executeUpdate();

		if (ps != null) {
			ps.close();
		}

	}

}
