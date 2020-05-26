/**
 * 
 */
package com.neuedu.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.shop.dao.CategoryMapper;
import com.neuedu.shop.entity.Category;
import com.neuedu.shop.service.CategoryService;

/**
 * @author 徐习飞
 * @date 2020年5月11日上午10:59:40
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper mapper;
	
	@Override
	public List<Category> findToTree() {
		return mapper.findToTree();
	}

	@Override
	public void addRootCategory(String name,String descr) {
		mapper.addRootCategory(name, descr);
	}

	@Override
	public void addChildCategory(String name,String descr,Integer pid) {
		// 查父类别的级别
		int grade = mapper.findByParentId(pid);
		// 添加
		mapper.addChildCategory(new Category(name, descr, pid, grade+1));
		// 更新父节点
		mapper.updateParentId(pid);
	}

	@Override
	public Category findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public List<Category> findThree() {
		return mapper.findThree();
	}

	@Override
	public void update(Category category) {
		mapper.update(category);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
	}

	@Override
	public List<Category> findAll() {
		
		return mapper.findAll();
	}

}
