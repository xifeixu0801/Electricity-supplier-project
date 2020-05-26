/**
 * 
 */
package com.neuedu.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.shop.entity.Product;
import com.neuedu.shop.entity.ProductConditionVO;

/**
 * @author 徐习飞
 * @date 2020年5月12日上午10:37:01
 */
@Repository
public interface ProductMapper {
	List<Product> findAll();
	List<Product> findEight();
	void insert(Product product);
	void update(Product product);
	void delete(Integer id);
	Product findById(Integer id);
	List<Product> fingByKeywords(String keywords);
	List<Product> lastedProduct();
//	按类别查找
	List<Product> findByCategoryId(Integer categoryid);
	/**
	 * 复杂查询的实现
	 * @param vo
	 * @return
	 */
	List<Product> ProductCondition(ProductConditionVO vo);
}
