package ja.co.example.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.co.example.dao.ProductDao;
import ja.co.example.entity.Product;
import ja.co.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product findById(Integer id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public List<Product> findByPrice(Integer price) {
		return productDao.findByPrice(price);
	}

	@Override
	public List<Product> findByNameAndPrice(String name, Integer price) {
		return productDao.findByNameAndPrice(name, price);
	}

	@Override
	public List<Product> find(String name, Integer price) {
		if (name == null && price == null) {
			return findAll();
		}

		if (name == null && price != null) {
			return findByPrice(price);
		}

		if (name != null && price == null) {
			return findByName(name);
		}

		if (name != null && price != null) {
			return findByNameAndPrice(name, price);
		}

		return Collections.emptyList();
	}

	@Override
	public int insert(Product product) {
		return productDao.insert(product);
	}

}
