package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.Role;

public interface RoleService {
	public List<Role> findAll();

	public Role findById(Integer roleId);
}
