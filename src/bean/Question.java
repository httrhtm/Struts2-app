package bean;

public class Question {

	public int id;
	public String question;

	public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }

	public Question() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

}
