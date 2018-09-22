package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.CstlinkmanBiz;
import com.baidu.dao.CstlinkmanDao;
import com.baidu.struts.entity.CstLinkman;

public class CstlinkmanBizIMPL  implements CstlinkmanBiz{

	private CstlinkmanDao cstlinkmanDao;
	
	public void setCstlinkmanDao(CstlinkmanDao cstlinkmanDao) {
		this.cstlinkmanDao = cstlinkmanDao;
	}
	@Override
	public CstLinkman cstLing(int lkmId) {
		// TODO Auto-generated method stub
		return cstlinkmanDao.cstLing(lkmId);
	}
	@Override
	public List<CstLinkman> cstLinkmans(String custNo) {
		return cstlinkmanDao.cstLinkmans(custNo);
	}
	@Override
	public int AddCslinKman(CstLinkman cstLinkman) {
		return cstlinkmanDao.AddCslinKman(cstLinkman);
	}
	@Override
	public int dateCslink(int lkmId) {
		return cstlinkmanDao.dateCslink(lkmId);
	}
	@Override
	public int updateCl(CstLinkman cstLinkman)  {
		return cstlinkmanDao.updateCl(cstLinkman);
	}

}
