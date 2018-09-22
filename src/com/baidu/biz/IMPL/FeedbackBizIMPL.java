package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.FeedbackBiz;
import com.baidu.dao.FeedbackDao;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public class FeedbackBizIMPL implements FeedbackBiz{

	private FeedbackDao feedbackDao;
	public void setFeedbackDao(FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}
	@Override
	public List<CstService> findCstServices(int curPage,int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return feedbackDao.findCstServices(curPage, pageSize, serviceForm);
	}
	@Override
	public CstService findByID(int id) {
		// TODO Auto-generated method stub
		return feedbackDao.findByID(id);
	}
	@Override
	public int updateCstservice(CstService cstService) {
		// TODO Auto-generated method stub
		return feedbackDao.updateCstservice(cstService);
	}
	@Override
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return feedbackDao.getMaxPage(curPage, pageSize, serviceForm);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return feedbackDao.getCount();
	}
	@Override
	public int getSize(ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		return feedbackDao.getSize(serviceForm);
	}
}
