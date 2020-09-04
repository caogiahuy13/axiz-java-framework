package jp.co.axiz.web.controller.form;

public class SelectForm {
	private String userName;
	private String tel;

	public SelectForm() {

	}

	public SelectForm(String userName, String tel) {
		this.userName = userName;
		this.tel = tel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
