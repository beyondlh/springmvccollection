package com.hdsx.lh.entities;

import java.util.Map;

/**
 * 产品字典
 */
public class ProductMap {
	private Map<String, Product> items;
	public Map<String, Product> getItems() {
		return items;
	}
	public void setItems(Map<String, Product> items) {
		this.items = items;
	}
}
