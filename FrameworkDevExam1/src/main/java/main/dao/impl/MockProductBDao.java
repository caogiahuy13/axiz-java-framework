package main.dao.impl;

import org.springframework.stereotype.Repository;

import main.dao.MockProductDao;

@Repository
public class MockProductBDao implements MockProductDao {
	public String find() {
		return "シャーペン";
	}
}
