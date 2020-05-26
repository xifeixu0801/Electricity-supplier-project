/**
 * 
 */
package com.neuedu.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.shop.dao.UserMapper;
import com.neuedu.shop.entity.User;
import com.neuedu.shop.service.UserService;
import com.neuedu.shop.util.CommonsUtil;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午11:29:45
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> findAll() {
		return mapper.findAll();
	}

	@Override
	public User login(String name, String pwd) {
		User user = mapper.findByName(name);
		if (user != null && user.getPassword().equals(CommonsUtil.transformToMD5(pwd))) {
			return user;
		}
		return null;
	}

	@Override
	public User findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public void register(User user) {
		mapper.insert(user);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
		
	}

	@Override
	public User findByName(String name) {
		
		return mapper.findByName(name);
	}

	@Override
	public void resetPassword(Integer id) {
		mapper.resetPassword(id);
		
	}

	@Override
	public void update(User user) {
//		User user2 = mapper.findById(user.getId());
		user.setName(user.getName());
		user.setPassword(user.getPassword());
		user.setPhone(user.getPhone());
		user.setAddr(user.getAddr());
		mapper.update(user);
		
	}



}
