package jp.co.axiz.web.controller.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {
	@NotBlank
	private String id;

	@NotBlank
	private String pass;

	public LoginForm() {

	}

	public LoginForm(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
