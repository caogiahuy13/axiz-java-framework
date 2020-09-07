package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.util.ParamUtil;

@Repository
public class UserDaoImpl implements UserDao {
	private static final String USER_NAME = "user_name";
	private static final String TELEPHONE = "telephone";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public User authenticate(String loginId, String password) {
		String sql = "SELECT * FROM user_info JOIN role ON user_info.role_id = role.role_id WHERE login_id = :loginId AND password = :password";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("loginId", loginId);
		paramMap.addValue("password", password);
		List<User> users = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<User>(User.class));
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user_info JOIN role ON user_info.role_id = role.role_id ORDER BY user_id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> find(User user) {
		ArrayList<String> conditionList = new ArrayList<>();
		ArrayList<Object> paramList = new ArrayList<>();
		ArrayList<String> handleList = new ArrayList<>();

		String userName = null;
		String telephone = null;

		if (user != null) {
			userName = user.getUserName();
			telephone = user.getTelephone();
		}

		if (ParamUtil.isNullOrEmpty(userName) && ParamUtil.isNullOrEmpty(telephone)) {
			return findAll();
		}

		if (!ParamUtil.isNullOrEmpty(userName)) {
			conditionList.add(USER_NAME + "= :" + USER_NAME + " ");
			paramList.add(userName);
			handleList.add(USER_NAME);
		}

		if (!ParamUtil.isNullOrEmpty(telephone)) {
			conditionList.add(TELEPHONE + " = :" + TELEPHONE + " ");
			paramList.add(telephone);
			handleList.add(TELEPHONE);
		}

		String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));

		String sql = "SELECT * FROM user_info JOIN role ON user_info.role_id = role.role_id WHERE " + whereString
				+ "ORDER BY user_id";

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		IntStream.range(0, paramList.size())
				.forEach(i -> paramMap.addValue(handleList.get(i), paramList.get(i)));

		return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public int insert(User user) {
		String sql = "INSERT INTO user_info (login_id, user_name, telephone, password, role_id) VALUES (:loginId, :userName, :telephone, :password, :roleId)";

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("loginId", user.getLoginId());
		paramMap.addValue("userName", user.getUserName());
		paramMap.addValue("telephone", user.getTelephone());
		paramMap.addValue("password", user.getPassword());
		paramMap.addValue("roleId", user.getRoleId());

		return jdbcTemplate.update(sql, paramMap);
	}

	@Override
	public User findByLoginId(String loginId) {
		String sql = "SELECT * FROM user_info JOIN role ON user_info.role_id = role.role_id WHERE login_id = :loginId";

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("loginId", loginId);

		List<User> users = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<User>(User.class));

		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user_info SET login_id = :loginId, user_name = :userName, telephone = :telephone, password = :password, role_id = :roleId WHERE user_id = :userId";

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("userId", user.getUserId());
		paramMap.addValue("loginId", user.getLoginId());
		paramMap.addValue("userName", user.getUserName());
		paramMap.addValue("telephone", user.getTelephone());
		paramMap.addValue("password", user.getPassword());
		paramMap.addValue("roleId", user.getRoleId());

		return jdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int deleteById(Integer userId) {
		String sql = "DELETE FROM user_info WHERE user_id = :userId";

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("userId", userId);

		return jdbcTemplate.update(sql, paramMap);
	}
}
