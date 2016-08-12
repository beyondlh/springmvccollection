package com.hdsx.lh.services;

import com.hdsx.lh.entities.ProductType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	private static List<ProductType> productTypes;

	static {
		productTypes = new ArrayList<ProductType>();
		productTypes.add(new ProductType(11, "数码电子"));
		productTypes.add(new ProductType(21, "鞋帽服饰"));
		productTypes.add(new ProductType(31, "图书音像"));
		productTypes.add(new ProductType(41, "五金家电"));
		productTypes.add(new ProductType(51, "生鲜水果"));
	}

	public ProductType getProductTypeById(int id) {
		for (ProductType productType : productTypes) {
			if (productType.getId() == id) {
				return productType;
			}
		}
		return null;
	}

	public List<ProductType> getAllProductTypes() {
		return productTypes;
	}

}
