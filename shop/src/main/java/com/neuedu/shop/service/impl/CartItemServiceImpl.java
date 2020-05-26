/**
 * 
 */
package com.neuedu.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.shop.dao.CartItemMapper;
import com.neuedu.shop.entity.CartItem;
import com.neuedu.shop.service.CartItemService;

/**
 * @author 徐习飞
 * @date 2020年5月15日下午8:05:39
 */
@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private CartItemMapper mapper;
	
	@Override
	public List<CartItem> findByUserId(Integer userid) {
		return mapper.findByUserId(userid);
	}

	@Override
	public void insert(CartItem cartItem) {
		mapper.insert(cartItem);

	}

}
