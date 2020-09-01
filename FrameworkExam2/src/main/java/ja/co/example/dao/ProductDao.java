package ja.co.example.dao;

import ja.co.example.entity.Product;

public interface ProductDao {
	public Product find(Integer productId);

	public int delete(Integer productId);
}
