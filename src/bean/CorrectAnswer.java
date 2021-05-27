package bean;

public class CorrectAnswer {

	public int id;
	public int questions_id;
	public String answer;

	public CorrectAnswer() {

	}
	public CorrectAnswer(int id, int questions_id, String answer) {
        this.id = id;
        this.questions_id = questions_id;
        this.answer = answer;
    }
	public CorrectAnswer(int id, String answer) {
		this.id = id;
        this.answer = answer;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionsId() {
		return questions_id;
	}
	public void setQuestionsId(int questions_id) {
		this.questions_id = questions_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
