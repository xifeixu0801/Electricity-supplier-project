/**
 * 
 */
package com.neuedu.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neuedu.shop.entity.User;
import com.neuedu.shop.service.UserService;

/**
 * @author 徐习飞
 * @date 2020年5月8日下午6:55:05
 */
@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/back/findAll.user")
	public String findAll(ModelMap map) {
		List<User> users = service.findAll();
		map.addAttribute("users", users);
		return "user_list.jsp";
	}
	
	@RequestMapping("/back/findById.user")
	public String findById(ModelMap map) {
		User users = service.findById(2);
		map.addAttribute("users", users);
		return "user_list.jsp";
	}
	
	@RequestMapping("/pre/insert.user")
	public String addUser(User user,ModelMap map) {
		service.register(user);
		return "redirect:user_login.jsp";
	}
	
	@RequestMapping(value = "/back/resetPassword.user",method =RequestMethod.GET)
	public String resetPassword(Integer id) {
		service.resetPassword(id);
		return "redirect:findAll.user";
	}
	// 前台重置密码
//	@RequestMapping(value = "/pre/resetPassword.user",method =RequestMethod.GET)
//	public String resetPasswordPre(Integer id) {
//		service.resetPassword(id);
//		return "redirect:findAll.user";
//	}
	
	@RequestMapping("/back/delete.user")
	public String delete(Integer id) {
		service.delete(id);
		return "redirect:findAll.user";
	}
	
	@RequestMapping("/pre/login.user")
	public String login(String name,String pwd,String code,HttpSession session,ModelMap map) {
//		System.out.println(name+pwd);
//		return "";
		User user = service.login(name, pwd);
		if (user != null) {
			session.setAttribute("user", user);
			return "index.product";
			
		}else {
			map.addAttribute("error_msg", "用户名或密码错误");
			return "user_login.jsp";
		}
		
	}
	
	@RequestMapping("/pre/logout.user")
	public String logout(HttpSession session) {
		// 销毁session中的对象
		session.invalidate();
		return "redirect:user_login.jsp";
	}
}
