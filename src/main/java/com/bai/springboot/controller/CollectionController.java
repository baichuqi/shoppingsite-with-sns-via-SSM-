package com.bai.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bai.springboot.entity.Collection;
import com.bai.springboot.service.ICollectionService;


@RestController
@RequestMapping("Collection")
public class CollectionController {
	private final ICollectionService collectionService;
	@Autowired
	public CollectionController(ICollectionService collectionService) {
		this.collectionService =collectionService;
	}
	@PostMapping()
	public String save(Collection c) {
		
		collectionService.save(c);
	
		return "save success";
	}
	@PutMapping("{id}")
	public String update(Collection c,@PathVariable String id) {
		
		if(collectionService.findById(id)==null) {
			return "not found";
		}
		if(c.getProductId()!=id ) {
			return "not matched";
		}
		collectionService.update(c);
		return "update success";
	}
	@DeleteMapping("{id}")
	public String delete(@PathVariable String id) {
		collectionService.delete(id);
		
		return "delete success";
	}
	@GetMapping()
	public List<Collection> list(){
		return collectionService.list();
	}
	@GetMapping("{id}")
	public Collection findById(@PathVariable String id) {
		return collectionService.findById(id);
	}
}
