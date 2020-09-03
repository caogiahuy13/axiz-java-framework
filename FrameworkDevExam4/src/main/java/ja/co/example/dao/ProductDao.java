package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.Product;

public interface ProductDao {
	public Product findById(Integer id);

	public List<Product> findAll();

	public List<Product> findByName(String name);

	public List<Product> findByPrice(Integer price);

	public List<Product> findByNameAndPrice(String name, Integer price);

	public int insert(Product product);

	public int delete(Integer id);

	public int update(Product product);
}
