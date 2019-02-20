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
import org.springframework.web.bind.support.SessionStatus;

import com.bai.springboot.entity.User;
import com.bai.springboot.service.IUserService;

@SessionAttributes(value={"user"})
@RestController
@RequestMapping("User")
public class UserController {
	
	private final IUserService userService;
	@Autowired
	public UserController (IUserService userService) {
		this.userService = userService;
	}
	
	@PostMapping()
	public String save(User u) {
		
		userService.save(u);
	
		return "save success";
	}
	@PutMapping("{id}")
	public String update(User u,@PathVariable String id) {
		
		if(userService.findById(id)==null) {
			return "not found";
		}
		if(u.getId()!=id) {
			return "not matched";
		}
		userService.update(u);
		return "update success";
	}
	@DeleteMapping("{id}")
	public String delete(@PathVariable String id) {
		userService.delete(id);
		
		return "delete success";
	}
	@GetMapping()
	public List<User> list(){
		return userService.list();
	}
	@GetMapping("{id}")
	public User findById(@PathVariable String id) {
		return userService.findById(id);
	}
	@PostMapping("/login")
    public String SessionAttributes(Model model,HttpSession session,User u){
		//String pwd =u.getPassword();
		String msg = "ログインしてください";
		if(session.getAttribute("user")!=null) {
			msg = "もうログインしました。使用者変わる場合が、ログインアウトボタン押してください";
		}else{
		    User u1 =	userService.findById(u.getId());
		    if(u1==null||!(u1.getPassword().equals(u.getPassword()))) {
		    	msg = "ログインが失敗しました。idまたはパスワードを確認してください";
		    }else {
		    	model.addAttribute("user",u1);
		        session.setAttribute("user", u1);
		        msg = "ログインできました";
		    }
	        
		}
        return msg;
    }
	@RequestMapping("/logined")
	public String logined(Model model,HttpSession session) {
		String isLogined = "false";
		if(session.getAttribute("user")!=null) {
			User u = (User) session.getAttribute("user");
			isLogined = u.getId();
		}
		return isLogined;		
	}
	@RequestMapping("/cancle")
	public String cancle(SessionStatus sessionStatus,HttpSession session) {
		//session.invalidate();
		session.removeAttribute("user");
		session.invalidate();
		sessionStatus.setComplete();
		return "login out";		
	}

}
