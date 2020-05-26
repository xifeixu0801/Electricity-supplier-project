/**
 * 
 */
package com.neuedu.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.shop.entity.User;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午9:41:33
 * @Repository用于标注数据访问组件，即DAO组件
 */
@Repository
public interface UserMapper {
	List<User> findAll();
	User findById(Integer id);
	User findByName(String name);
	void delete(Integer id);
	void insert(User user);
	void update(User user);
	/*重置密码*/
	void resetPassword(Integer id);
}
