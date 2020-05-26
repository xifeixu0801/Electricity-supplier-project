/**
 * 
 */
package com.neuedu.shop.service;

import java.util.List;

import com.neuedu.shop.entity.CartItem;


/**
 * 
 * @author 徐习飞
 * @date 2020年5月15日下午8:04:06
 */
public interface CartItemService {
	List<CartItem> findByUserId(Integer userid);
	void insert(CartItem cartItem);
}
