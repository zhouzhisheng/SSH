package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.BasdictBiz;
import com.baidu.dao.BasdictDao;
import com.baidu.struts.entity.BasDict;
import com.baidu.struts.form.BasdictForm;

public class BasdictBizIMPL implements BasdictBiz {

	private BasdictDao basdictDao;
	public void setBasdictDao(BasdictDao basdictDao) {
		this.basdictDao = basdictDao;
	}
	
	@Override
	public int addbasDict(BasDict basDict) {
		// TODO Auto-generated method stub
		return basdictDao.addbasDict(basDict);
	}
	@Override
	public BasDict findByID(int dict_id) {
		// TODO Auto-generated method stub
		return basdictDao.findByID(dict_id);
	}
	@Override
	public int updatebasdict(BasDict basDict) {
		// TODO Auto-generated method stub
		return basdictDao.updatebasdict(basDict);
	}
	@Override
	public int deletebasdict(int dict_id) {
		// TODO Auto-generated method stub
		return basdictDao.deletebasdict(dict_id);
	}
	@Override
	public List<BasDict> findAllBasDicts(BasdictForm basdictForm) {
		// TODO Auto-generated method stub
		return basdictDao.findAllBasDicts(basdictForm);
	}
}
