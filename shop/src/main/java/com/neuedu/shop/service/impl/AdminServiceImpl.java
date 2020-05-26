/**
 * 
 */
package com.neuedu.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.shop.dao.AdminMapper;
import com.neuedu.shop.entity.Admin;
import com.neuedu.shop.service.AdminService;
import com.neuedu.shop.util.CommonsUtil;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午11:54:11
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper mapper;
	
	@Override
	public List<Admin> findAdminAll() {
		
		return mapper.findAdminAll();
	}

	@Override
	public Admin login(String name, String pwd) {
		Admin admin = mapper.findByName(name);
		if (admin != null && admin.getPassword().equals(CommonsUtil.transformToMD5(pwd))) {
			return admin;
		}
		return null;
	}

	@Override
	public void insert(Admin admin) {
		mapper.insert(admin);
	}

	@Override
	public void update(Admin admin) {
		mapper.update(admin);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
	}

	@Override
	public Admin findById(Integer id) {
		
		return mapper.findById(id);
	}
	

}
