/**
 * 
 */
package com.neuedu.shop.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.shop.dao.AdminMapper;
import com.neuedu.shop.entity.Admin;

/**
 * @author 徐习飞
 * @date 2020年5月8日下午12:00:48
 * @ContextConfiguration(locations = {"classpath:beans.xml"})
 * location是数组，如果只有一个引用文件{}，可以去掉
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class AdminTest {
	
	@Autowired
	private AdminMapper mapper;
	
	/*
	 * @Test public void findAllAdmin() { List<Admin> admins =
	 * mapper.findAdminAll(); for (Admin admin : admins) {
	 * System.out.println(admin); } }
	 */

	@Test
	public void findByName() {
		Admin admin = mapper.findByName("徐习飞");
		System.out.println(admin);
	}
	
	@Test
	public void insert() {
		mapper.insert(new Admin("Tom","111111"));
		
	}
	
	@Test
	public void delete() {
		mapper.delete(11);
	}
	@Test
	public void findById() {
		Admin admin = mapper.findById(5);
		System.out.println(admin);
	}
	
	@Test
	public void updateAdmin() {
		Admin admin = mapper.findById(13);
		admin.setName("小妹妹呀");
		admin.setPassword("000000");
		mapper.update(admin);
	}
}
