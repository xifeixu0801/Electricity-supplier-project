/**
 * 
 */
package com.neuedu.shop.dao;

import java.util.List;

import com.neuedu.shop.entity.CartItem;

/**
 * @author 徐习飞
 * @date 2020年5月15日下午2:53:33
 */
public interface CartItemMapper {
	// 业务中，在后台管理中，不需要查看用户购物车内容
//	List<CartItem> findAll();
	/**
	 * 根据用户id（userid）查找购物项
	 * @param userid
	 * @return
	 */
	List<CartItem> findByUserId(Integer userid);
	// 往数据表中添加数据
	void insert(CartItem cartItem);
	void update(CartItem cartItem);
}
