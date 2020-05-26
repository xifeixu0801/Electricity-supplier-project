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

import com.neuedu.shop.entity.CartItem;
import com.neuedu.shop.entity.User;
import com.neuedu.shop.service.CartItemService;

/**
 * @author 徐习飞
 * @date 2020年5月15日下午8:08:34
 */
@Controller
public class CartItemController {
	@Autowired
	private CartItemService service;
	
	@RequestMapping("/pre/findByUserId.cartitem")
	public String findByUserId(HttpSession session,ModelMap map) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:user_login.jsp";
		}
		List<CartItem> cartitems = service.findByUserId(user.getId());
		
		
//		for (Iterator<CartItem> iterator = cartitems.iterator();iterator.hasNext();) {
//			CartItem cartItem = iterator.next();
//			System.out.println(cartItem);
//		}
		map.addAttribute("cartitems", cartitems);
		return "forward:cart.jsp";
	}
	
	@RequestMapping("/pre/insertCartitem.cartitem")
	public  String insertCartitem() {
		return "";
	}
}
