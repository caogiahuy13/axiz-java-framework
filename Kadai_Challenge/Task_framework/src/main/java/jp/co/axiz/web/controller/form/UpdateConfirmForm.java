package jp.co.axiz.web.controller.form;

import javax.validation.constraints.NotBlank;

public class UpdateConfirmForm {
	private Integer userId;

	private String loginId;

	private String userName;

	private String tel;

	private Integer roleId;

	private String roleName;

	private String pass;

	@NotBlank
	private String rePass;

	public UpdateConfirmForm() {

	}

	public UpdateConfirmForm(Integer userId, String loginId, String userName, String tel, Integer roleId,
			String roleName,
			String pass, String rePass) {
		this.userId = userId;
		this.loginId = loginId;
		this.userName = userName;
		this.tel = tel;
		this.roleId = roleId;
		this.pass = pass;
		this.roleName = roleName;
		this.rePass = rePass;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRePass() {
		return rePass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

}
