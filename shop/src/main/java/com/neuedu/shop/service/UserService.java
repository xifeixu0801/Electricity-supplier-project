/**
 * 
 */
package com.neuedu.shop.service;

import java.util.List;

import com.neuedu.shop.entity.User;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午9:35:31
 */
public interface UserService {
	List<User> findAll();
	User login(String name,String pwd);
	/**
	 * @return
	 */
	User findById(Integer id);
	void register(User user);
	void delete(Integer id);
	User findByName(String name);
	void resetPassword(Integer id);
	void update(User user);
}
