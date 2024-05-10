package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService ps;

	@PostMapping
	public Product p1(@RequestBody Product p) {
		return ps.save(p);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> p2(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
		Pageable p=PageRequest.of(page, size);
		Page<Product> pp=ps.findAll(p);
		return ResponseEntity.ok(pp.getContent());
	}
	
	@GetMapping("/{di}")
	public Product p3(@PathVariable int di) {
		return ps.findByDi(di);
	}
	
	@DeleteMapping("/{di}")
	public void p4(@PathVariable int di) {
		ps.deleteByDi(di);
	}
	
	@PutMapping("/{di}")
	public Product p5(@PathVariable int di, @RequestBody Product p) {
		return ps.update(di, p);
	}
	
	
}
