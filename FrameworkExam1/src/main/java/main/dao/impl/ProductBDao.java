package main.dao.impl;

import org.springframework.stereotype.Repository;

import main.dao.ProductDao;

@Repository
public class ProductBDao implements ProductDao {

	public String find() {
		return "消しゴム";

	}

}
