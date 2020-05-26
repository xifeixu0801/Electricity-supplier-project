/**
 * 
 */
package com.neuedu.shop.service;

import java.util.List;

import com.neuedu.shop.entity.Category;

/**
 * @author 徐习飞
 * @date 2020年5月11日上午10:57:34
 */
public interface CategoryService {
	List<Category> findAll();
	List<Category> findToTree();
	void addRootCategory(String name,String descr);
	void addChildCategory(String name,String descr,Integer pid);
	Category findById(Integer id);
	List<Category> findThree();
	void update(Category category);
	void delete(Integer id);
}
