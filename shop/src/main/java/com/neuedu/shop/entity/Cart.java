/**
 * 
 */
package com.neuedu.shop.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author 徐习飞
 * @date 2020年5月15日下午2:18:57
 */
@Data
public class Cart {
	// 懒汉式
	private static Cart cart = new Cart();
	private List<CartItem> items;
	/**
	 * 
	 */
	private Cart() {
		items = new ArrayList<CartItem>();
	}
	
	public static Cart getInstance() {
		return cart;
	}
}
