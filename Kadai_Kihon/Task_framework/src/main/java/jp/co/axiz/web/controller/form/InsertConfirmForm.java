package jp.co.axiz.web.controller.form;

public class InsertConfirmForm {
	private String loginId;

	private String userName;

	private String tel;

	private Integer roleId;

	private String roleName;

	private String pass;

	private String rePass;

	public InsertConfirmForm() {

	}

	public InsertConfirmForm(String loginId, String userName, String tel, Integer roleId, String roleName, String pass,
			String rePass) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.tel = tel;
		this.roleId = roleId;
		this.roleName = roleName;
		this.pass = pass;
		this.rePass = rePass;
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

	public String getRePass() {
		return rePass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
