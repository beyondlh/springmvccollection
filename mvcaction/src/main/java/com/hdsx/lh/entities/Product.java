package com.hdsx.lh.entities;

import java.io.Serializable;

/**
 * 产品
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "编号(id)："+this.getId()+"，名称(name)："+this.getName()+"，价格(price)："+this.getPrice();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
