package com.baidu.biz.IMPL;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.baidu.biz.CstCustomerBiz;
import com.baidu.dao.CstCustomerDao;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.form.CstCustomerForm;

public class CstCustomerBizIMPL implements CstCustomerBiz{

	private CstCustomerDao cstcustomerDao;

	public void setCstcustomerDao(CstCustomerDao cstcustomerDao) {
		this.cstcustomerDao = cstcustomerDao;
	}

	@Override
	public List<CstCustomer> querySalchance(int pageSize, int curpage,
			CstCustomerForm csForm) {
		return cstcustomerDao.querySalchance(pageSize, curpage, csForm);
	}

	@Override
	public int getMaxpage(int pageSize, CstCustomerForm cForm) {
		// TODO Auto-generated method stub
		return cstcustomerDao.getMaxpage(pageSize, cForm);
	}

	@Override
	public int page(CstCustomerForm cForm) {
		// TODO Auto-generated method stub
		return cstcustomerDao.page(cForm);
	}

	@Override
	public CstCustomer cs(String custNo) {
		return cstcustomerDao.cs(custNo);
	}

	@Override
	public CstCustomer dateCstCustomer(String custNo) {
		return cstcustomerDao.dateCstCustomer(custNo);
	}

	@Override
	public int updateCs(CstCustomer cs) {
		return cstcustomerDao.updateCs(cs);
	}
	
}
