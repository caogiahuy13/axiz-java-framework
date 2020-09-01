package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.ProductDao;
import ja.co.example.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Product find(Integer productId) {
		String sql = "SELECT * FROM products WHERE product_id = :product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", productId);
		List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public int delete(Integer productId) {
		String sql = "DELETE FROM products WHERE product_id = :product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", productId);

		return jdbcTemplate.update(sql, param);
	}

}
