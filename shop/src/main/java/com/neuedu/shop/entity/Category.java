/**
 * 
 */
package com.neuedu.shop.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐习飞
 * @date 2020年5月11日上午10:04:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7690722187544638748L;
	private Integer id;
	private String name;
	private String descr;
	private Integer pid;
	
	private Boolean leaf;
	private Integer grade;
	
//	private String keyword;
//	存放子类别的容器
	private List<Category> children;
	/**
	 * @param name
	 * @param descr
	 * @param pId
	 * @param grade
	 */
	public Category(String name, String descr, Integer pid, Integer grade) {
		this.name = name;
		this.descr = descr;
		this.pid = pid;
		this.grade = grade;
	}
	/**
	 * @param name
	 * @param descr
	 * @param pId
	 */
	public Category(String name, String descr, Integer pid) {
		this.name = name;
		this.descr = descr;
		this.pid = pid;
	}
	
	
}
