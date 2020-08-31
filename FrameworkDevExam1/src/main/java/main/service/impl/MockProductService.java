package main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import main.dao.MockProductDao;
import main.service.ProductService;

@Service
public class MockProductService implements ProductService {
	@Autowired
	@Qualifier("mockProductADao")
	private MockProductDao mockProductDao;

	public String find() {
		return mockProductDao.find();
	}
}
