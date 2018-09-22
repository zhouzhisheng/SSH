package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public interface DealDao {

	/*
	 * 查询服务处理
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
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
	
	/*
	 * 根据编号查询服务分配信息
	 */
	public CstService ByID(int id);
	
	/*
	 * 添加服务处理信息
	 */
	public int uodateCstservice(CstService cstService);
}
