package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.Product;

public interface ProductDao {
	public List<Product> findAll();

	public Product find(Integer productId);

	public int insert(Product product);

	public int delete(Integer productId);

	public int update(Product product);
}
