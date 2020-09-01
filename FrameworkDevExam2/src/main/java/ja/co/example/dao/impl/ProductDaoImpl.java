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
	public List<Product> findAll() {
		String sql = "SELECT * FROM products ORDER BY product_id";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public Product find(Integer productId) {
		String sql = "SELECT * FROM products WHERE product_id = :product_id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("product_id", productId);
		List<Product> resultList = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<Product>(Product.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public int insert(Product product) {
		String sql = "INSERT INTO products (product_name, price) VALUES (:product_name, :price)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("product_name", product.getProductName());
		paramMap.addValue("price", product.getPrice());

		return jdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int delete(Integer productId) {
		String sql = "DELETE FROM products WHERE product_id = :product_id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("product_id", productId);

		return jdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int update(Product product) {
		String sql = "UPDATE products SET product_name = :product_name, price = :price WHERE product_id = :product_id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("product_id", product.getProductId());
		paramMap.addValue("product_name", product.getProductName());
		paramMap.addValue("price", product.getPrice());

		return jdbcTemplate.update(sql, paramMap);
	}

}
