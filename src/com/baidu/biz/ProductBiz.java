package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.Product;
import com.baidu.struts.form.ProductForm;

public interface ProductBiz {

	/*
	 * ��ѯ���
	 */
	public List<Product> findAllProducts(int curPage, int pageSize,ProductForm productForm);
	
	/*
	 * ��ѯ���ҳ��
	 */
	public int getMaxPage(int curPage, int pageSize, ProductForm productForm); 
	
	/*
	 * ��ѯ��¼
	 */
	public int getCount();
	
	/*
	 * ת���ڼ�ҳ
	 */
	public int getPage(ProductForm productForm);
}
