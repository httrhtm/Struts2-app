package action;

import bean.CorrectAnswer;
import bean.Question;
import dao.CorrestAnswersDao;
import dao.QuestionsDao;

public class RegisterAction {

	private String question;
	private String answer;
	private String errorMessage;
	private String[] ansAry;

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String[] getAnsAry() {
		return ansAry;
	}
	public void setAnsAry(String[] ansAry) {
		this.ansAry = ansAry;
	}

	/*
	 * Register Comfirm
	 */
	public String confirm() throws Exception {

		ansAry = answer.split("[\\s]*,[\\s]*", 0);

		// Validation
		if(question.length() == 0) {
			return showMessage("問題を入力してください");
		} else if (question.length() > 500) {
			return showMessage("問題を500文字以下で入力してください");
		}
		if (ansAry.length != 0) {
			for (int j = 0; j < ansAry.length; j++) {
				if (ansAry[j].length() > 200) {
					return showMessage("答えを200文字以下で入力してください");
				}
			}
		} else {
			return showMessage("答えを入力してください");
		}
		return "success";
	}

	public String showMessage(String errorMessage) {
		this.errorMessage=errorMessage;
		return "error";
	}
	public String showExceptionMessage(String errorMessage) {
		this.errorMessage=errorMessage;
		return "error";
	}

	/*
	 * Insert
	 */
	public String insert() throws Exception {

		QuestionsDao qdao = new QuestionsDao();
		CorrestAnswersDao cadao = new CorrestAnswersDao();

		Question q = new Question();
		CorrectAnswer ca = new CorrectAnswer();

		// Question
		q.setQuestion(question);
		qdao.create(q);

		// Answer
		ansAry = answer.split(",");


		for (int j = 0; j < ansAry.length; j++) {
			ca.setAnswer(ansAry[j].trim());
			cadao.create(ca);
		}

		return "success";
	}

}
