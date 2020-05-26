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
 * @date 2020年5月12日上午10:28:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2680839058744400514L;
	private Integer id;
	private String name;
	private String descr;
	private Double normalprice;
	private Double memberprice;
	private	String imgpath;
	private Timestamp pdate;
	private Integer categoryid;
	
	private Category category;

	/**
	 * @param name
	 * @param descr
	 * @param normalprice
	 * @param memberprice
	 * @param imgpath
	 * @param category
	 */
	public Product(String name, String descr, Double normalprice, Double memberprice, String imgpath,
			Category category) {
		this.name = name;
		this.descr = descr;
		this.normalprice = normalprice;
		this.memberprice = memberprice;
		this.imgpath = imgpath;
		this.category = category;
	}

	public Product(String name, String descr, Double normalprice, Double memberprice, String imgpath,
			Integer categoryid) {
		this.name = name;
		this.descr = descr;
		this.normalprice = normalprice;
		this.memberprice = memberprice;
		this.imgpath = imgpath;
		this.categoryid = categoryid;
	}
	

	
	
}
