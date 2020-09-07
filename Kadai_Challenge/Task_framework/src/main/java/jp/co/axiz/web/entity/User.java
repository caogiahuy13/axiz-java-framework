package jp.co.axiz.web.entity;

import java.util.Date;

public class User {
	private Integer userId;
	private String loginId;
	private String userName;
	private String telephone;
	private String password;
	private Integer roleId;
	private String roleName;
	private Date createDatetime;
	private Date updateDatetime;

	public User() {

	}

	public User(Integer userId, String loginId, String userName, String telephone, String password, Integer roleId,
			String roleName) {
		this.userId = userId;
		this.loginId = loginId;
		this.userName = userName;
		this.telephone = telephone;
		this.password = password;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	private User(Builder builder) {
		this.userId = builder.userId;
		this.loginId = builder.loginId;
		this.userName = builder.userName;
		this.telephone = builder.telephone;
		this.password = builder.password;
		this.roleId = builder.roleId;
		this.roleName = builder.roleName;
		this.createDatetime = builder.createDatetime;
		this.updateDatetime = builder.updateDatetime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer userId;
		private String loginId;
		private String userName;
		private String telephone;
		private String password;
		private Integer roleId;
		private String roleName;
		private Date createDatetime;
		private Date updateDatetime;

		private Builder() {
		}

		public Builder userId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public Builder loginId(String loginId) {
			this.loginId = loginId;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder telephone(String telephone) {
			this.telephone = telephone;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder roleId(Integer roleId) {
			this.roleId = roleId;
			return this;
		}

		public Builder roleName(String roleName) {
			this.roleName = roleName;
			return this;
		}

		public Builder createDatetime(Date createDatetime) {
			this.createDatetime = createDatetime;
			return this;
		}

		public Builder updateDatetime(Date updateDatetime) {
			this.updateDatetime = updateDatetime;
			return this;
		}

		public User build() {
			return new User(this);
		}
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDateTime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDateTime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
