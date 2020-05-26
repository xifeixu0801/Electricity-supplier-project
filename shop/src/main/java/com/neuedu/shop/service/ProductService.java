/**
 * 
 */
package com.neuedu.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neuedu.shop.entity.Product;
import com.neuedu.shop.entity.ProductConditionVO;

/**
 * @author 徐习飞
 * @date 2020年5月12日下午3:19:34
 */
public interface ProductService {
	List<Product> findAll();
	List<Product> findEight();	
	void update(Product product);
	void delete(Integer id);
	Product findById(Integer id);
//	与mapper层不同之处
	void insert(Product product,CommonsMultipartFile file,HttpServletRequest request );
	
	List<Product> fingByKeywords(String keywords);
	List<Product> lastedProduct();
	List<Product> findByCategoryId(Integer categoryid);
	List<Product> ProductCondition(ProductConditionVO vo);
}
