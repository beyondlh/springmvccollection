package com.hdsx.lh.services;

import com.hdsx.lh.entities.ProductType;

import java.util.List;

/**
 * 产品类型服务
 *
 */
public interface ProductTypeService {
	/**
	 * 根据产品类型编号获得产品类型对象
	 */
	public ProductType getProductTypeById(int id);
	
	/**
	 * 获得所有的产品类型
	 */
	public List<ProductType> getAllProductTypes();
}
