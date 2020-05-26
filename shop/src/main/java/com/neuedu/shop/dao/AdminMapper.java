/**
 * 
 */
package com.neuedu.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.shop.entity.Admin;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午11:52:53
 */
@Repository
public interface AdminMapper {
	List<Admin> findAdminAll();
	/**
	 * 与登录有关的，根据名称查看是否存在该管理员
	 */
	Admin findByName(String name);
	Admin findById(Integer id);
	void insert(Admin admin);
	void update(Admin admin);
	void delete(Integer id);
}
