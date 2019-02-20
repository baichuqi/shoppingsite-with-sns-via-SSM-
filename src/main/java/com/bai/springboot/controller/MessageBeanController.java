package com.bai.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bai.springboot.entity.Cart;
import com.bai.springboot.entity.MessageBean;
import com.bai.springboot.service.IMessageBeanService;

@RestController
@RequestMapping("MessageBean")
public class MessageBeanController {

		private final IMessageBeanService messageService;
		@Autowired
		public MessageBeanController(IMessageBeanService messageService) {
			this.messageService=messageService;
		}
		@PostMapping()
		public String save(MessageBean m) {
			
			messageService.save(m);
		
			return "save success";
		}
		@GetMapping()
		public List<MessageBean> list(){
			return messageService.list();
		}
		@GetMapping("{id}")
		public MessageBean findById(@PathVariable String id) {
			return messageService.findById(id);
		}
		
}
