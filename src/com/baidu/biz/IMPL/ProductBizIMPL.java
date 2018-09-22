package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.ProductBiz;
import com.baidu.dao.ProductDao;
import com.baidu.struts.entity.Product;
import com.baidu.struts.form.ProductForm;

public class ProductBizIMPL implements ProductBiz {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAllProducts(int curPage, int pageSize,ProductForm productForm) {
		// TODO Auto-generated method stub
		return productDao.findAllProducts(curPage,pageSize,productForm);
	}

	@Override
	public int getMaxPage(int curPage, int pageSize, ProductForm productForm) {
		// TODO Auto-generated method stub
		return productDao.getMaxPage(curPage, pageSize, productForm);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return productDao.getCount();
	}

	@Override
	public int getPage(ProductForm productForm) {
		// TODO Auto-generated method stub
		return productDao.getPage(productForm);
	}	
}
