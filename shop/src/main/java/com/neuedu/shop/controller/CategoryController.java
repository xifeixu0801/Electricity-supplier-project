/**
 * 
 */
package com.neuedu.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.shop.entity.Category;
import com.neuedu.shop.service.CategoryService;

/**
 * @author 徐习飞
 * @date 2020年5月11日下午12:31:42
 */
@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;

	@RequestMapping("/back/findAll.category")
	public List<Category> findAll() {
		return service.findAll();
	}
	@RequestMapping("/back/findToTree.category")
	@ResponseBody
	public List<Category> findToTree() {
		return service.findToTree();
	}
	@RequestMapping("/back/addRootCategory.category")
	public String addRootCategory(String name,String descr) {
		service.addRootCategory(name, descr);
		return "redirect:category_list.jsp";
	}
	
	@RequestMapping("/back/addChildCategory.category")
	public String addChildCategory(String name,String descr,Integer pid) {
		service.addChildCategory(name, descr, pid);
		return "redirect:category_list.jsp";
	}
	@RequestMapping("/back/findById.category")
	public String findById(Integer id,ModelMap map) {
		Category category = service.findById(id);
		map.addAttribute("category", category);
		return "category_addChild.jsp";
	}
	@RequestMapping("/back/findById_update.category")
	public String updatefindById(Integer id,ModelMap map,HttpServletRequest request) {
		Category category = service.findById(id);
		map.addAttribute("category", category);
		return "category_update.jsp";
	}
	
	@RequestMapping("/back/updateCategory.category")
	public String updateCategory(Integer id,ModelMap map) {
		Category category = service.findById(id);
//		String name = category.getName();
//		String descr = category.getDescr();
//		category.setName(name);
//		category.setDescr(descr);
		service.update(category);
		return "redirect:category_list.jsp";
	}
	@RequestMapping("/back/deleteCategory.category")
	public String deleteCategory(Integer id) {
		service.delete(id);
		
		return "redirect:category_list.jsp";
	}
	
	@RequestMapping("/back/findThree.category")
	@ResponseBody
	public List<Category> findThree(Integer id) {
		return service.findThree();
	}
	
}
