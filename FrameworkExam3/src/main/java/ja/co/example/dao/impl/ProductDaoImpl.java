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
	public Product findById(Integer id) {
		String sql = "SELECt * FROM products WHERE product_id = :id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);

		List<Product> list = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<Product>(Product.class));

		return list.isEmpty() ? null : list.get(0);
	}

}
