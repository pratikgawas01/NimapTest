package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository cr;
	
	@Override
	public Page<Category> findAll(Pageable p) {
		return cr.findAll(p);
	}
	
	@Override
	public Category save(Category c) {
		return cr.save(c);
	}

	@Override
	public Category findByDi(int di) {
		return cr.findById(di).orElseThrow();
	}

	@Override
	public void deleteByDi(int di) {
		cr.deleteById(di);
	}

	@Override
	public Category update(int di, Category c) {
		Category c2=cr.findById(di).orElseThrow();
		c2.setName(c.getName());
		c2.setProducts(c.getProducts());
		return cr.save(c2);
	}


}

