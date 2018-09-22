package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.StorageDao;
import com.baidu.struts.entity.Storage;
import com.baidu.struts.form.StorageForm;

public class StorageDaoIMPL extends HibernateDaoSupport implements StorageDao{

	@Override
	public List<Storage> findAllStorages(int curPage, int pageSize,
			StorageForm storageForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("select s from Storage s,Product p where p.prodId=s.product.prodId");
		if (storageForm.getProName() != null
				&& storageForm.getProName().trim() != "") {
			stringBuffer.append(" and p.prodName like '%"
					+ storageForm.getProName() + "%'");
		}
		if (storageForm.getStkWarehouse() != null
				&& storageForm.getStkWarehouse().trim() != "") {
			stringBuffer.append(" and s.stkWarehouse like '%"
					+ storageForm.getStkWarehouse() + "%'");
		}
		List<Storage> list = getSession().createQuery(stringBuffer.toString())
				.setFirstResult((curPage - 1) * pageSize)
				.setMaxResults(pageSize).list();
		//List<Storage> list=getSession().createQuery(stringBuffer.toString()).list();
		return list;
	}

	@Override
	public int getMaxPage(int curPage, int pageSize, StorageForm storageForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0/" + pageSize
				+ ") from Storage s,Product p where p.prodId=s.product.prodId");
		if (storageForm.getProName() != null
				&& storageForm.getProName().trim() != "") {
			stringBuffer.append(" and p.prodName like '%"
					+ storageForm.getProName() + "%'");
		}
		if (storageForm.getStkWarehouse() != null
				&& storageForm.getStkWarehouse().trim() != "") {
			stringBuffer.append(" and s.stkWarehouse like '%"
					+ storageForm.getStkWarehouse() + "%'");
		}
		double result = (Double) getSession().createQuery(stringBuffer.toString())
				.uniqueResult();
		int maxPage = (int) result;
		return maxPage;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="select COUNT(*) from Storage";
		long result=(Long)getSession().createQuery(sql).uniqueResult();
		int count=(int)result;
		return count;
	}

	@Override
	public int getSize(StorageForm storageForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0) from Storage s,Product p where p.prodId=s.product.prodId");
		if (storageForm.getProName() != null
				&& storageForm.getProName().trim() != "") {
			stringBuffer.append(" and p.prodName like '%"
					+ storageForm.getProName() + "%'");
		}
		if (storageForm.getStkWarehouse() != null
				&& storageForm.getStkWarehouse().trim() != "") {
			stringBuffer.append(" and s.stkWarehouse like '%"
					+ storageForm.getStkWarehouse() + "%'");
		}
		double result = (Double) getSession().createQuery(stringBuffer.toString())
				.uniqueResult();
		int page = (int) result;
		return page;
	}
}
