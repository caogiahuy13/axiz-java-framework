package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.RoleDao;
import jp.co.axiz.web.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Role> findAll() {
		String sql = "SELECT * FROM role ORDER BY role_id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
	}

	@Override
	public Role findById(Integer roleId) {
		String sql = "SELECT * FROM role WHERE role_id = :roleId";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("roleId", roleId);
		List<Role> roles = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<Role>(Role.class));
		return roles.isEmpty() ? null : roles.get(0);
	}

}
