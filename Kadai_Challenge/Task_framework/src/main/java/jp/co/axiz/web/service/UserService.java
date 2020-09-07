package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.User;

public interface UserService {
	public User authenticate(String loginId, String password);

	public List<User> findAll();

	public List<User> find(User user);

	public User findById(Integer userId);

	public User findByLoginId(String loginId);

	public int insert(User user);

	public int update(User user);

	public int deleteById(Integer userId);
}
