package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User authenticate(String loginId, String password) {
		return userDao.authenticate(loginId, password);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> find(User user) {
		return userDao.find(user);
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User findById(Integer userId) {
		return userDao.findById(userId);
	}

	@Override
	public User findByLoginId(String loginId) {
		return userDao.findByLoginId(loginId);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int deleteById(Integer userId) {
		return userDao.deleteById(userId);
	}

}
