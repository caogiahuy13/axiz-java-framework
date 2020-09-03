package ja.co.example.service.impl;

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

}
