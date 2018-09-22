package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.DealBiz;
import com.baidu.dao.DealDao;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public class DealBizIMPL implements DealBiz {

	private DealDao dealDao;

	public void setDealDao(DealDao dealDao) {
		this.dealDao = dealDao;
	}

	@Override
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return dealDao.findCstServices(curPage,pageSize,serviceForm);
	}

	@Override
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return dealDao.getMaxPage(curPage, pageSize, serviceForm);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dealDao.getCount();
	}

	@Override
	public int getSize(ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return dealDao.getSize(serviceForm);
	}

	@Override
	public CstService ByID(int id) {
		// TODO Auto-generated method stub
		return dealDao.ByID(id);
	}

	@Override
	public int updateCstservice(CstService cstService) {
		// TODO Auto-generated method stub
		return dealDao.uodateCstservice(cstService);
	}

}
