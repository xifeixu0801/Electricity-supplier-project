/**
 * 
 */
package com.neuedu.shop.service;

import java.util.List;

import com.neuedu.shop.entity.Admin;

/**
 * @author ĞìÏ°·É
 * @date 2020Äê5ÔÂ8ÈÕÉÏÎç11:53:41
 */
public interface AdminService {
	List<Admin> findAdminAll();
	/**
	 * µÇÂ¼Âß¼­
	 */
	
	Admin login(String name,String pwd);
	Admin findById(Integer id);
	void insert(Admin admin);
	void update(Admin admin);
	void delete(Integer id);
}
