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

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM products ORDER BY product_id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public List<Product> findByName(String name) {
		String sql = "SELECT * FROM products WHERE product_name = :name ORDER BY product_id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", name);

		return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public List<Product> findByPrice(Integer price) {
		String sql = "SELECT * FROM products WHERE price = :price ORDER BY product_id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("price", price);

		return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public List<Product> findByNameAndPrice(String name, Integer price) {
		String sql = "SELECT * FROM products WHERE product_name = :name AND price = :price ORDER BY product_id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", name);
		paramMap.addValue("price", price);

		return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public int insert(Product product) {
		String sql = "INSERT INTO products (product_name, price) VALUES (:name, :price)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", product.getProductName());
		paramMap.addValue("price", product.getPrice());

		return jdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM products WHERE product_id = :id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);
		return jdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int update(Product product) {
		String sql = "UPDATE products SET product_name = :name, price = :price WHERE product_id = :id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", product.getProductId());
		paramMap.addValue("name", product.getProductName());
		paramMap.addValue("price", product.getPrice());
		return jdbcTemplate.update(sql, paramMap);
	}

}
