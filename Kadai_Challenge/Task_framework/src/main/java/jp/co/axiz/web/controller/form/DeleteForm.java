package jp.co.axiz.web.controller.form;

import javax.validation.constraints.NotBlank;

public class DeleteForm {
	@NotBlank
	private String loginId;

	public DeleteForm() {

	}

	public DeleteForm(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
