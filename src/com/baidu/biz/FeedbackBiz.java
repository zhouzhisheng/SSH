package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public interface FeedbackBiz {

		/*
	 * 查询服务反馈
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * 根据编号查询服务反馈
	 */
	public CstService findByID(int id);
	
	/*
	 * 添加服务反馈的结果和满意度
	 */
	public int updateCstservice(CstService cstService);
	
	/*
	 * 查询最大页数
	 */
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm); 
	
	/*
	 * 查询记录
	 */
	public int getCount();
	
	/*
	 * 跳转到多少也
	 */
	public int getSize(ServiceForm serviceForm);
}
