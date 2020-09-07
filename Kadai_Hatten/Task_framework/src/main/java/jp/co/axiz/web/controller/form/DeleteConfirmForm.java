package jp.co.axiz.web.controller.form;

public class DeleteConfirmForm {
	private Integer userId;

	public DeleteConfirmForm() {

	}

	public DeleteConfirmForm(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
