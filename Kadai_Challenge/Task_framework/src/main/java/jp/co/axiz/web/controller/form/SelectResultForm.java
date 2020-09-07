package jp.co.axiz.web.controller.form;

public class SelectResultForm {
	private String[] userIDs;

	public SelectResultForm() {

	}

	public SelectResultForm(String[] userIds) {

	}

	public String[] getUserIDs() {
		return userIDs;
	}

	public void setUserIDs(String[] userIDs) {
		this.userIDs = userIDs;
	}

}
