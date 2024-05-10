package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Category;

public interface CategoryService {

	Page<Category> findAll(Pageable p);
	Category save(Category c);
	Category findByDi(int di);
	void deleteByDi(int di);
	Category update(int di, Category c);
}
