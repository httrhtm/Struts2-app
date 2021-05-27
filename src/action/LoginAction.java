package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UsersDao;

public class LoginAction extends ActionSupport implements SessionAware {

	private int id;
	private String name;
	private String password;
	private String errorMessage;
	private SessionMap<String,Object> sessionMap;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/*
	 * Session
	 */
	@Override
	public void setSession(Map<String, Object> map) {
	    sessionMap=(SessionMap)map;
	}

	/*
	 * Login
	 */
	public String execute() {
		try {
			User user = UsersDao.getUser(id);
			if(id == 0) {
				return showMessage("IDを入力してください");
			}else if (password.length() == 0) {
				return showMessage("パスワードを入力してください");
			}else if(!password.equals(user.getPassword())) {
				return showMessage("パスワードが違います");
			}else {

				sessionMap.put("login","true");
				sessionMap.put("id",id);
			    sessionMap.put("name",name);
			    sessionMap.put("password",password);

				return "success";
			}
		}catch(SQLException e) {
			return showExceptionMessage("DBの例外が発生しました。");
		}
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
	 * Logout
	 */
	public String logout(){
	    if(sessionMap!=null){
	        sessionMap.invalidate();
	    }
	    return "success";
	}

}
