package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.User;

public interface UserService {
	public User authenticate(String loginId, String password);

	public List<User> findAll();

	public List<User> find(User user);

	public User findByLoginId(String loginId);

	public int insert(User user);
}
