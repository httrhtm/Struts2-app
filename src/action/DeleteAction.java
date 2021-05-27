package action;

import java.util.ArrayList;
import java.util.List;

import bean.CorrectAnswer;
import bean.Question;
import dao.CorrestAnswersDao;
import dao.QuestionsDao;

public class DeleteAction {

	private int id;
	private Question q = new Question();
	private List<CorrectAnswer> ca = new ArrayList<CorrectAnswer>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Question getQ() {
		return q;
	}
	public void setQ(Question q) {
		this.q = q;
	}
	public List<CorrectAnswer> getCalist() {
		return ca;
	}
	public void setCalist(List<CorrectAnswer> calist) {
		this.ca = calist;
	}

	/*
	 * Delete Comfirm
	 */
	public String delete_confirm() throws Exception {

		QuestionsDao qdao = new QuestionsDao();
		CorrestAnswersDao cadao = new CorrestAnswersDao();

        q = qdao.findById(id);
        ca = cadao.findByQuestionsId(id);

        return "success";
	}

	/*
	 * Delete
	 */
	public String delete() throws Exception {

		QuestionsDao qdao = new QuestionsDao();
		CorrestAnswersDao cadao = new CorrestAnswersDao();

        qdao.delete(id);
        cadao.delete(id);

        System.out.println(id);

        return "success";
	}

}
