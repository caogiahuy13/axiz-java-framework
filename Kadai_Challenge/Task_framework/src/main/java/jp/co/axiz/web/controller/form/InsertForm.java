package jp.co.axiz.web.controller.form;

import javax.validation.constraints.NotBlank;

public class InsertForm {
	@NotBlank
	private String loginId;

	@NotBlank
	private String userName;

	@NotBlank
	private String tel;

	private Integer roleId;

	@NotBlank
	private String pass;

	public InsertForm() {

	}

	public InsertForm(String loginId, String userName, String tel, Integer roleId, String pass) {
		this.loginId = loginId;
		this.userName = userName;
		this.tel = tel;
		this.roleId = roleId;
		this.pass = pass;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
