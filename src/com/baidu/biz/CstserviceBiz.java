package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public interface CstserviceBiz {
	
	/*
	 * 添加客户服务
	 */
	public int addCstservice(CstService cstService);
	
	/*
	 * 查询服务归档(分页)
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * 查询服务归档的记录
	 */
	public int getCount();
	
	/*
	 * 查询服务归档的最大页数
	 */
	public int getMaxPage(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * 根据编号查询服务归档
	 */
	public CstService findByID(int ID);
	
	/*
	 * 跳转到多少也
	 */
	public int getSize(ServiceForm serviceForm);
	
	/*
	 * 查询客户服务分析
	 */
	public List<CstService> find(int year);
}
