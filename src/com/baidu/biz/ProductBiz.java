package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.Product;
import com.baidu.struts.form.ProductForm;

public interface ProductBiz {

	/*
	 * 查询库存
	 */
	public List<Product> findAllProducts(int curPage, int pageSize,ProductForm productForm);
	
	/*
	 * 查询最大页数
	 */
	public int getMaxPage(int curPage, int pageSize, ProductForm productForm); 
	
	/*
	 * 查询记录
	 */
	public int getCount();
	
	/*
	 * 转到第几页
	 */
	public int getPage(ProductForm productForm);
}
