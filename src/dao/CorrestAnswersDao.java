package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.CorrectAnswer;

public class CorrestAnswersDao {

	private static ArrayList<CorrectAnswer> calist = new ArrayList<CorrectAnswer>();
	private static ArrayList<CorrectAnswer> ca = new ArrayList<CorrectAnswer>();

	private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public CorrestAnswersDao() throws Exception {
		DBConnection.getConnect();
    }

    /**
     * 全件取得
     */
    public List<CorrectAnswer> findAll() throws Exception {
    	//DBConnectionからデータベースへの接続を得る
    	con = DBConnection.getConnect();

    	//SQL実行
    	String sql = "select * from correct_answers";
    	ps = con.prepareStatement(sql);
    	rs = ps.executeQuery();

    	while (rs.next()) {
    		int id = rs.getInt("id");
    		int questions_id = rs.getInt("questions_id");
    		String answer = rs.getString("answer");

    		CorrectAnswer bean = new CorrectAnswer(id, questions_id, answer);
    		calist.add(bean);
    	}

    	if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

    	return calist;
    }

    /**
	 * 新規作成
	 */
	public void create(CorrectAnswer ca) throws Exception {
		con = DBConnection.getConnect();

		String sql = "insert into correct_answers (questions_id, answer) values ((select id from questions order by created_at desc limit 1), ?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, ca.getAnswer());
		ps.executeUpdate();

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
	}

	/**
	 * 新規作成
	 */
	public List<CorrectAnswer> findByQuestionsId(int questions_id) throws Exception {
		con = DBConnection.getConnect();

    	//SQL実行
    	String sql = "select id, answer from correct_answers where questions_id = ?";
    	ps = con.prepareStatement(sql);
    	ps.setInt(1, questions_id);
    	rs = ps.executeQuery();

    	while (rs.next()) {
    		int id = rs.getInt("id");
    		String answer = rs.getString("answer");

    		CorrectAnswer bean = new CorrectAnswer(id, answer);
    		ca.add(bean);
    	}

    	if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

    	return ca;
	}

	public void delete(int questions_id) throws Exception {
		con = DBConnection.getConnect();

		String sql = "DELETE FROM correct_answers WHERE questions_id = ?";

		ps = con.prepareStatement(sql);
		ps.setInt(1, questions_id);
		ps.executeUpdate();

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

	}

}
