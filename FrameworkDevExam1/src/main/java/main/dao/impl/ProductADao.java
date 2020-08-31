package main.dao.impl;

import org.springframework.stereotype.Repository;

import main.dao.ProductDao;

@Repository
public class ProductADao implements ProductDao {

	public String find() {
		return "鉛筆";
	}

}
