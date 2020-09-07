package jp.co.axiz.web.controller.form;

import javax.validation.constraints.NotBlank;

public class UpdateInputForm {
	private Integer userId;

	@NotBlank
	private String loginId;

	@NotBlank
	private String userName;

	@NotBlank
	private String tel;

	private Integer roleId;

	private String roleName;

	@NotBlank
	private String pass;

	public UpdateInputForm() {

	}

	public UpdateInputForm(Integer userId, String loginId, String userName, String tel, Integer roleId, String roleName,
			String pass) {
		this.userId = userId;
		this.loginId = loginId;
		this.userName = userName;
		this.tel = tel;
		this.roleId = roleId;
		this.pass = pass;
		this.roleName = roleName;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
