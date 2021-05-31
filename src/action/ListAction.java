package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.CorrectAnswer;
import bean.Question;
import dao.CorrestAnswersDao;
import dao.QuestionsDao;

/*
 * ユーザ一覧表示アクションクラス
 */
public class ListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Question> qlist;
	private List<CorrectAnswer> calist;

	public List<Question> getQlist() {
		return qlist;
	}
	public void setQlist(List<Question> qlist) {
		this.qlist = qlist;
	}
	public List<CorrectAnswer> getCalist() {
		return calist;
	}
	public void setCalist(List<CorrectAnswer> calist) {
		this.calist = calist;
	}

	// 「/list.action」を呼び出した際に、execute()メソッドが実行される。
    public String execute() throws Exception {

        QuestionsDao qdao = new QuestionsDao();
        CorrestAnswersDao cadao = new CorrestAnswersDao();

        qlist = qdao.findAll();
        calist = cadao.findAll();

        return SUCCESS;
    }

}
