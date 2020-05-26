/**
 * 
 */
package com.neuedu.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.shop.entity.Category;

/**
 * @author 徐习飞
 * @date 2020年5月11日上午10:15:45
 */
@Repository
public interface CategoryMapper {
	/**
	 * 添加根类别
	 * @param category_name
	 * @param category_description
	 */
	void addRootCategory(String name ,String descr);
	
	/**
	 * 添加孩子节点
	 */
	int findByParentId(Integer pid);
	void addChildCategory(Category category);
	void updateParentId(Integer pid);
	/**
	 * 删除
	 * @param id
	 * @param category_parentId
	 */
//	int findByChildId(Integer id);
//	void delete(Integer id,int category_parentId);
	// 查询类别级别为3的所有类别，供添商品使用
	List<Category> findThree();
	Category findById(Integer id);
	List<Category> findAll();
	List<Category> findToTree();
	List<Category> fingByKeywords(String keyword);
	void update(Category category);
	void delete(Integer id);
	void insert(Category category);
}
