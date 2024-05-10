package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository pr;

	@Override
	public Page<Product> findAll(Pageable p) {
		return pr.findAll(p);
	}

	@Override
	public Product save(Product p) {
		return pr.save(p);
	}

	@Override
	public void deleteByDi(int di) {
		pr.deleteById(di);
	}

	@Override
	public Product findByDi(int di) {
		return pr.findById(di).orElseThrow();
	}

	@Override
	public Product update(int di, Product p) {
		Product p2=pr.findById(di).orElseThrow();
		p2.setName(p.getName());
		p2.setPrice(p.getPrice());
		p2.setCategory(p.getCategory());
		return pr.save(p2);
	}

}

