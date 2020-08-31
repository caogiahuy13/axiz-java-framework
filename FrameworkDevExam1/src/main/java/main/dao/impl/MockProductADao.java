package main.dao.impl;

import org.springframework.stereotype.Repository;

import main.dao.MockProductDao;

@Repository
public class MockProductADao implements MockProductDao {

	public String find() {
		return "定規";
	}

}
