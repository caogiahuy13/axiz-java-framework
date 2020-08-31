package main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import main.dao.ProductDao;
import main.service.ProductService;

@Service
public class DefaultProductService implements ProductService {
	@Autowired
	@Qualifier("productBDao")
	private ProductDao productDao;

	public String find() {
		return productDao.find();
	}
}
