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

import com.bai.springboot.entity.Cart;
import com.bai.springboot.service.ICartService;

@RestController
@RequestMapping("Cart")
public class CartController {

		private final ICartService cartService;
		@Autowired
		public CartController(ICartService cartService) {
			this.cartService =cartService;
		}
		@PostMapping()
		public String save(Cart c) {
			
			cartService.save(c);
		
			return "save success";
		}
		@PutMapping("{id}")
		public String update(Cart c,@PathVariable String id) {
			
			if(cartService.findById(id)==null) {
				return "not found";
			}
			if(c.getProductId()!=id ) {
				return "not matched";
			}
			cartService.update(c);
			return "update success";
		}
		@DeleteMapping("{id}")
		public String delete(@PathVariable String id) {
			cartService.delete(id);
			
			return "delete success";
		}
		@GetMapping()
		public List<Cart> list(){
			return cartService.list();
		}
		@GetMapping("{id}")
		public Cart findById(@PathVariable String id) {
			return cartService.findById(id);
		}
}
