package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.ProductDao;
import com.baidu.struts.entity.Product;
import com.baidu.struts.form.ProductForm;

public class ProductDaoIMPL extends HibernateDaoSupport implements ProductDao {
	@Override
	public List<Product> findAllProducts(int curPage, int pageSize,ProductForm productForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from Product where 1=1");
		if (productForm.getProdName() != null
				&& productForm.getProdName().trim().length()>0 ) {
			stringBuffer.append(" and prodName like '%"
					+ productForm.getProdName() + "%'");
		}
		if (productForm.getProdType() != null
				&& productForm.getProdType().trim().length()>0) {
			stringBuffer.append(" and prodType like '%"
					+ productForm.getProdType() + "%'");
		}
		if (productForm.getProdBatch() != null
				&& productForm.getProdBatch().trim().length()>0) {
			stringBuffer.append(" and prodBatch like '%"
					+ productForm.getProdBatch() + "%'");
		}
		List<Product> list = getSession().createQuery(stringBuffer.toString())
				.setFirstResult((curPage - 1) * pageSize)
				.setMaxResults(pageSize).list();
		return list;
	}

	@Override
	public int getMaxPage(int curPage, int pageSize, ProductForm productForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0/" + pageSize
				+ ") from Product where 1=1");
		if (productForm.getProdName() != null
				&& productForm.getProdName().trim() != "") {
			stringBuffer.append(" and prodName like '%"
					+ productForm.getProdName() + "%'");
		}
		if (productForm.getProdType() != null
				&& productForm.getProdType().trim() != "") {
			stringBuffer.append(" and prodType like '%"
					+ productForm.getProdType() + "%'");
		}
		if (productForm.getProdBatch() != null
				&& productForm.getProdBatch().trim() != "") {
			stringBuffer.append(" and prodBatch like '%"
					+ productForm.getProdBatch() + "%'");
		}
		double result = (Double) getSession().createQuery(stringBuffer.toString())
				.uniqueResult();
		int maxPage = (int) result;
		return maxPage;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="select COUNT(*) from Product";
		long result=(Long)getSession().createQuery(sql).uniqueResult();
		int count=(int)result;
		return count;
	}

	@Override
	public int getPage(ProductForm productForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0) from Product where 1=1");
		if (productForm.getProdName() != null
				&& productForm.getProdName().trim() != "") {
			stringBuffer.append(" and prodName like '%"
					+ productForm.getProdName() + "%'");
		}
		if (productForm.getProdType() != null
				&& productForm.getProdType().trim() != "") {
			stringBuffer.append(" and prodType like '%"
					+ productForm.getProdType() + "%'");
		}
		if (productForm.getProdBatch() != null
				&& productForm.getProdBatch().trim() != "") {
			stringBuffer.append(" and prodBatch like '%"
					+ productForm.getProdBatch() + "%'");
		}
		double result = (Double) getSession().createQuery(stringBuffer.toString())
				.uniqueResult();
		int page = (int) result;
		return page;
	}
}
