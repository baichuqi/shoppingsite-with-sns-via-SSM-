package com.bai.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bai.springboot.entity.Seller;
import com.bai.springboot.entity.User;
import com.bai.springboot.service.ISellerService;
@SessionAttributes("seller")
@RestController
@RequestMapping("Seller")
public class SellerController {

	private final ISellerService  sellerService;
	
	@Autowired
	public SellerController(ISellerService  sellerService) {
		this.sellerService = sellerService;
	}
	@PostMapping()
	public String save(Seller s) {
		sellerService.save(s);
		return "success";		
	}
	@PutMapping("{id}")
	public String update(Seller s,@PathVariable String id) {
			
			if(sellerService.findById(id)==null) {
				return "not found";
			}
			if(s.getId()!=id) {
				return "not matched";
			}
			sellerService.update(s);
			return "update success";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable String id) {
		sellerService.delete(id);
		
		return "delete success";
	}
	@GetMapping()
	public List<Seller> list(){
		return sellerService.list();
	}
	@GetMapping("{id}")
	public Seller findById(@PathVariable String id) {
		return sellerService.findById(id);
	}
	@RequestMapping("login")
	public String sellerLogin(Model model,HttpSession session,Seller s) {
		String msg = "ログインしてください";
		if(session.getAttribute("seller")!=null) {
			//Seller s2 = (Seller) session.getAttribute("seller");
			msg = "もうログインしました。使用者変わる場合が、ログインアウトボタン押してください";
		}else{
		    Seller s1 =	sellerService.findById(s.getId());
		    if(s1==null||!(s1.getPassword().equals(s.getPassword()))) {
		    	msg = "ログインが失敗しました。idまたはパスワードを確認してください";
		    }else {
		    	model.addAttribute("seller",s1);
		        session.setAttribute("seller", s1);
		        msg = "ログインできました";
		    }
	        
		}
        return msg;
		
	}
	@RequestMapping("logined")
	public Seller SellerLogined(Model model,HttpSession session) {
		
		return (Seller)session.getAttribute("seller");
	}
	@RequestMapping("cancle")
	public String SellerCancle(Model model,HttpSession session) {
		
		session.removeAttribute("seller");
		
		return "cancle success";
	}
	
}
