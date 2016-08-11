package com.hdsx.lh.services;

import com.hdsx.lh.entities.Product;

import java.util.List;

public interface ProductService {

	/*
	 * 获得所有的产品
	 */
	List<Product> getAllProducts();

	/*
	 * 获得产品通过编号
	 */
	Product getProductById(int id);

	/*
	 * 获得产品名称通过名称
	 */
	List<Product> getProductsByName(String productName);

	/**
	 * 新增产品对象
	 */
	void addProduct(Product enttiy);
	
	/**
	 * 更新产品对象
	 */
	public void updateProduct(Product entity);

	/**
	 * 删除产品对象
	 */
	void deleteProduct(int id);

	/**
	 * 多删除产品对象
	 */
	void deletesProduct(int[] ids);

}