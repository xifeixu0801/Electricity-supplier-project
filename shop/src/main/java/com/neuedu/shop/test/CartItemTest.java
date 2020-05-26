/**
 * 
 */
package com.neuedu.shop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.shop.dao.CartItemMapper;
import com.neuedu.shop.dao.ProductMapper;
import com.neuedu.shop.entity.CartItem;
import com.neuedu.shop.entity.Product;

/**
 * @author 徐习飞
 * @date 2020年5月15日下午3:02:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class CartItemTest {
	@Autowired
	private CartItemMapper cimapper;
	@Autowired
	private ProductMapper pmapper;
	@Test
	public void insert() {
		Product product = pmapper.findById(35);
		cimapper.insert(new CartItem(product.getId(), 2, 1, product.getMemberprice()));
	}
	
	@Test
	public void findByUserId() {
		List<CartItem> items = cimapper.findByUserId(6);
		items.forEach((item)->{
			System.out.println(item);
		});
	}
	
//	@Test
//	public void update() {
//		List<CartItem> cartitems = cimapper.findByUserId(6);
//	}
}
