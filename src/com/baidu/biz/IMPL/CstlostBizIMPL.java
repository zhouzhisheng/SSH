package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.CstlostBiz;
import com.baidu.dao.CstlostDao;
import com.baidu.struts.entity.CstLost;
import com.baidu.struts.form.CstCustomerForm;

public class CstlostBizIMPL implements CstlostBiz{

	private CstlostDao cstlostDao;
	
	public void setCstlostDao(CstlostDao cstlostDao) {
		this.cstlostDao = cstlostDao;
	}
	@Override
	public List<CstLost> CLost(int pageSize, int curPage, CstCustomerForm cForm) {
		return cstlostDao.CLost(pageSize, curPage, cForm);
	}
	@Override
	public int getMapg(int pageSize, CstCustomerForm csForm) {
		return cstlostDao.getMapg(pageSize, csForm);
	}
	@Override
	public int page(CstCustomerForm cForm) {
		return cstlostDao.page(cForm);
	}
	@Override
	public CstLost CuLost(int lstId) {
		return cstlostDao.CuLost(lstId);
	}
	@Override
	public int AddCstLost(CstLost cs) {
		return cstlostDao.AddCstLost(cs);
	}
	@Override
	public int updateCstLost(CstLost cs) {
		return cstlostDao.updateCstLost(cs);
	}

	

}
