package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.AssignBiz;
import com.baidu.dao.AssignDao;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.entity.SysUser;
import com.baidu.struts.form.ServiceForm;

public class AssignBizIMPL implements AssignBiz {

	private AssignDao assignDao;
	
	public void setAssignDao(AssignDao assignDao) {
		this.assignDao = assignDao;
	}

	@Override
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return assignDao.findCstServices(curPage,pageSize,serviceForm);
	}

	@Override
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return assignDao.getMaxPage(curPage, pageSize, serviceForm);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return assignDao.getCount();
	}

	@Override
	public int getSize(ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return assignDao.getSize(serviceForm);
	}

	@Override
	public List<SysUser> findAll() {
		// TODO Auto-generated method stub
		return assignDao.findAll();
	}

	@Override
	public int updateCstservice(CstService cstService) {
		// TODO Auto-generated method stub
		return assignDao.updateCstservice(cstService);
	}

	@Override
	public SysUser findByID(int id) {
		// TODO Auto-generated method stub
		return assignDao.findByID(id);
	}

	@Override
	public CstService getByID(int id) {
		// TODO Auto-generated method stub
		return assignDao.getByID(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return assignDao.delete(id);
	}	
}
