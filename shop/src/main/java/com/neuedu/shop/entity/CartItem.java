/**
 * 
 */
package com.neuedu.shop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐习飞
 * @date 2020年5月15日下午2:18:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2116863400478275841L;
	private Integer id;
	private Integer productid;
	private Integer userid;
	private Integer pcount;
	private Double unitprice ;
	private Timestamp  itemdate;
	
	private Product product ;
	private User user ;
	/**
	 * @param productid
	 * @param userid
	 * @param pcount
	 * @param unitprice
	 */
	public CartItem(Integer productid, Integer userid, Integer pcount, Double unitprice) {
		this.productid = productid;
		this.userid = userid;
		this.pcount = pcount;
		this.unitprice = unitprice;
	}
	/**
	 * @param pcount
	 * @param unitprice
	 * @param product
	 * @param user
	 */
	public CartItem(Integer pcount, Double unitprice, Product product, User user) {
		this.pcount = pcount;
		this.unitprice = unitprice;
		this.product = product;
		this.user = user;
	}
	
}
