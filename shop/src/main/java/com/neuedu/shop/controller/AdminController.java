/**
 * 
 */
package com.neuedu.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.shop.entity.Admin;
import com.neuedu.shop.service.AdminService;

/**
 * @author 徐习飞
 * @date 2020年5月8日下午2:19:16
 */
@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	@RequestMapping("/back/findAll.admin")
	public String findAll(ModelMap map) {
		List<Admin> admins = service.findAdminAll();
		map.addAttribute("admins", admins);
		return "admin_list.jsp";
	}
	@RequestMapping("/back/login.admin")
	public String login(String name,String pwd,String code,HttpSession session,ModelMap map) {
		Admin admin = service.login(name, pwd);
//System.out.println(admin);
		if (admin != null) {
//System.out.println(admin);			
			// 从session对象中获取验证码
			String codeStr = (String)session.getAttribute("checkcode");
//System.out.println(codeStr);
			if (codeStr.equalsIgnoreCase(code)) {
				// 将admin绑定，便于验证
				session.setAttribute("admin", admin);
				return "redirect:index.jsp";
			}else {
				map.addAttribute("code_msg","验证码错误");
				return "admin_login.jsp";
			}
		}else {
			map.addAttribute("error_msg","用户名或密码错误");
			return "admin_login.jsp";
		}
		
	}
	@RequestMapping("/back/updateAdmin.admin")
	public String update(Integer id,Admin admin,ModelMap map) {
		Admin updateAdmin = service.findById(id);
		map.addAttribute("updateAdmin", updateAdmin);
		
		updateAdmin.setName(admin.getName());
		updateAdmin.setPassword(admin.getPassword());
		service.update(updateAdmin);
		return "redirect:findAll.admin";
	}
	
	@RequestMapping("/back/delete.admin")
	public String delete(Integer id) {
		service.delete(id);
		return "redirect:findAll.admin";
	}
	
	
	@RequestMapping("/back/insert.admin")
	public String addAdmin(Admin admin,ModelMap map) {
		service.insert(admin);
		return "redirect:admin_login.jsp";
		
	}

	@RequestMapping("/back/logout.admin")
	public String logout(HttpSession session) {
		// 销毁session中的对象
		session.invalidate();
		return "redirect:admin_login.jsp";
	}
	
}
