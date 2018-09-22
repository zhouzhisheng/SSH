package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.CstserviceBiz;
import com.baidu.dao.CstserviceDao;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public class CstserviceBizIMPL implements CstserviceBiz{
	private CstserviceDao cstserviceDao;

	public void setCstserviceDao(CstserviceDao cstserviceDao) {
		this.cstserviceDao = cstserviceDao;
	}

	@Override
	public int addCstservice(CstService cstService) {
		// TODO Auto-generated method stub
		return cstserviceDao.addCstservice(cstService);
	}
	
	@Override
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return cstserviceDao.findCstServices(curPage,pageSize,serviceForm);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cstserviceDao.getCount();
	}

	@Override
	public int getMaxPage(int curPage, int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return cstserviceDao.getMaxPage(curPage, pageSize,serviceForm);
	}

	@Override
	public CstService findByID(int ID) {
		// TODO Auto-generated method stub
		return cstserviceDao.findByID(ID);
	}

	@Override
	public int getSize(ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return cstserviceDao.getSize(serviceForm);
	}

	@Override
	public List<CstService> find(int year) {
		// TODO Auto-generated method stub
		return cstserviceDao.find(year);
	}
}
