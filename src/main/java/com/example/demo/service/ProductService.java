package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Product;

public interface ProductService {

	Page<Product> findAll(Pageable p);
	Product save(Product p);
	void deleteByDi(int di);
	Product findByDi(int di);
	Product update(int di, Product p);
}
