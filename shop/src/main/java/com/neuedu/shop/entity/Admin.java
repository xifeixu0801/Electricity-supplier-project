/**
 * 
 */
package com.neuedu.shop.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午11:50:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 829509212868678398L;
	private Integer id;
	private String name;
	private String password;
	/**
	 * @param name
	 * @param password
	 */
	public Admin(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
}
