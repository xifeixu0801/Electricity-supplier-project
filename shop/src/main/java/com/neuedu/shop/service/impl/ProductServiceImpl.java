/**
 * 
 */
package com.neuedu.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neuedu.shop.dao.ProductMapper;
import com.neuedu.shop.entity.Product;
import com.neuedu.shop.entity.ProductConditionVO;
import com.neuedu.shop.service.ProductService;
import com.neuedu.shop.util.CommonsUtil;

/**
 * @author 徐习飞
 * @date 2020年5月12日下午3:21:51
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<Product> findAll() {
		
		return mapper.findAll();
	}

	@Override
	public void update(Product product) {
		mapper.update(product);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);

	}

	

	@Override
	public List<Product> fingByKeywords(String keywords) {
		
		return mapper.fingByKeywords(keywords);
	}

	@Override
	public List<Product> lastedProduct() {
		
		return mapper.lastedProduct();
	}

	@Override
	public void insert(Product product, CommonsMultipartFile file, HttpServletRequest request) {
		// 上传到服务器
		String path = request.getServletContext().getRealPath("/") + "/images/" + 
				UUID.randomUUID().toString().replace("-", "")
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		File f = new File(path); 
		// 判断服务器中是否有该路径
		File fileParent = f.getParentFile();
		// 若没有该路径，创建该路径
		if(!fileParent.exists()) {
			fileParent.mkdirs();
			}
		
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 将图片路径存入数据库
		// 先对imgpath进行解析，再将数据存入数据库
		String imgpath = null;
		imgpath="/images" + path.substring(path.lastIndexOf("/"));
		product.setImgpath(imgpath);
		mapper.insert(product);
		// 将图片对象存入本地
		CommonsUtil.fileCypeToLocal(path, 
				"F:\\eclipse-workspace\\Neuedu_shop6\\src\\main\\webapp"+imgpath);
	}

	@Override
	public Product findById(Integer id) {
		
		return mapper.findById(id);
	}

	@Override
	public List<Product> findEight() {
		
		return mapper.findEight();
	}

	@Override
	public List<Product> findByCategoryId(Integer categoryid) {
		return mapper.findByCategoryId(categoryid);
	}

	@Override
	public List<Product> ProductCondition(ProductConditionVO vo) {
		
		return mapper.ProductCondition(vo);
	}

}
