/**
 * 
 */
package com.neuedu.shop.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.shop.dao.UserMapper;
import com.neuedu.shop.entity.User;

/**
 * @author 徐习飞
 * @date 2020年5月8日下午12:30:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserTest {
	@Autowired
	private UserMapper mapper;
	
//	@Test
//	public void findAll() {
//		List<User> users = mapper.findAll();
//		for (User user : users) {
//			System.out.println(user);
//		}
		// lambda表达式java8+才能使用，就是增强for循环
//		users.forEach(user->{
//			System.out.println(user);
//		});
//	}
	@Test
	public void findByName() {
		User user = mapper.findByName("王悦");
		System.out.println(user);
	}
	@Test
	public void findById() {
		User user = mapper.findById(2);
		System.out.println(user);
	}
	
	@Test
	public void deleteUser() {
		mapper.delete(3);
	}
	
	@Test
	public void update() {
		User user = mapper.findById(6);
		user.setName("王悦");
		mapper.update(user);
		
	}
	
	@Test
	public void addUser() {
		mapper.insert(new User("小妹妹", "520520", "18298765432", "马鞍山"));
	}
	
	@Test
	public void resetPassword() {
		mapper.resetPassword(6);
	}
	
	@Test
	public void insert() {
		mapper.insert(new User("张三", "123456", "13965627185", "安徽省马鞍山市"));
	}
}
