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

import com.neuedu.shop.dao.ProductMapper;
import com.neuedu.shop.entity.Product;
import com.neuedu.shop.entity.ProductConditionVO;

/**
 * @author 徐习飞
 * @date 2020年5月12日下午12:03:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class ProductTest {
	@Autowired
	private ProductMapper mapper;
	
	@Test
	public void insert() {
		mapper.insert(new Product("测试123", "测试123", 777.0, 666.0, "#", 33));
		
	}
	
	@Test
	public void findAll() {
		List<Product> products = mapper.findAll();
		products.forEach(p->System.out.println(p));
	}
	
	@Test
	public void findEight() {
		List<Product> products = mapper.findEight();
		products.forEach(p->System.out.println(p));
	}
	@Test
	public void delete() {
		mapper.delete(1);
		
	}
	@Test
	public void update() {
		Product product = mapper.findById(3);
		product.setName("a大 第三方大");
		product.setDescr("测试啊");
		product.setNormalprice(9999.9);
		product.setMemberprice(6666.6);
		product.setCategoryid(40);
		product.setImgpath("#");
		mapper.update(product);;
		
	}
	@Test
	public void findByKeywords() {
		List<Product> products = mapper.fingByKeywords("啊");
		
		products.forEach(p->System.out.println(p));
	}
	
	@Test
	public void findByCategoryId() {
		List<Product> products = mapper.findByCategoryId(31);
		products.forEach(p->System.out.println(p));
	}
	@Test
	public void lastedProduct() {
		List<Product> products = mapper.lastedProduct();
//		for (Product product : products) {
//			System.out.println(product);
//		}
		
//		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
//			Product product = (Product) iterator.next();
//			System.out.println(product);
//			
//		}
		
//		products.forEach(p->System.out.println(p));
		
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
	}
	@Test
	public void ProductCondition() {
		//categoryid, keywords, lownormalprice, highnormalprice, lowmemberprice, highmemberprice, startdate, enddate
		List<Product> products = mapper.ProductCondition(new ProductConditionVO(null, "动感", null, null, 3000.0, 5000.0, null, null));
		for (Product product : products) {
			System.out.println(product.getNormalprice());
		}
		products.forEach(p->System.out.println(p));
	}
	
	
}
