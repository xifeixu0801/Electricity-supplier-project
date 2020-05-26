/**
 * 
 */
package com.neuedu.shop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.shop.dao.CategoryMapper;
import com.neuedu.shop.entity.Category;
import com.neuedu.shop.service.CategoryService;


/**
 * @author 徐习飞
 * @date 2020年5月11日上午10:37:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class CategoryTest {
	@Autowired
	private CategoryMapper mapper;
	@Autowired
	private CategoryService service;

	@Test
	public void findToTree() {
		List<Category> categories = service.findToTree();
		categories.forEach(c -> System.out.println(c));

//		for (Category category : categories) {
//			System.out.println(category.getId());
//		}
//		System.out.println();

	}

	@Test
	public void findAll() {
		List<Category> categories = mapper.findAll();
		categories.forEach(c -> System.out.println(c));
	}

	/*
	 * @Test public void findToTree() { List<Category> categories =
	 * mapper.findToTree(); categories.forEach(c -> System.out.println(c)); }
	 */
	@Test
	public void findThree() {
		List<Category> categories = mapper.findThree();
		categories.forEach(c -> System.out.println(c));
	}

	@Test
	public void addRootCategory() {
		mapper.addRootCategory("测试数据", "测试数据");
	}

	@Test
	public void addChildCategory() {
		service.addChildCategory("测试数据11", "测试数据11", 30);
	}
	@Test
	public void updateCategory() {
		Category c = service.findById(41);
		c.setName("aaaaa111");
		c.setDescr("adasdas");
		service.update(c);;
	}

}
