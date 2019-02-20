package com.bai.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bai.springboot.entity.Product;
import com.bai.springboot.service.IProductService;

@RestController
@RequestMapping("Product")
public class ProductController {

	private final IProductService productService;
	//private IProductService productService;
	
	@Autowired
	public ProductController(IProductService productService) {
		this.productService = productService;
	}
	@PostMapping()
	public String save(Product p) {
		
		//productService.save(p);
	
		//return "save success";
		return p.getName();
	}
	@PutMapping("{id}")
	public String update(Product p,@PathVariable String id) {
		
		if(productService.findById(id)==null) {
			return "not found";
		}
		if(p.getId()!=id) {
			return "not matched";
		}
		productService.update(p);
		return "update success";
	}
	@DeleteMapping("{id}")
	public String delete(@PathVariable String id) {
		productService.delete(id);
		
		return "delete success";
	}
	@GetMapping()
	public List<Product> list(){
		return productService.list();
	}
	@GetMapping("{id}")
	public Product findById(@PathVariable String id) {
		return productService.findById(id);
	}
	
}
