package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.CstLost;
import com.baidu.struts.entity.OrdersLine;

public interface OrderBiz {

	/*
	 * 查询客户贡献
	 */
	public List<OrdersLine> findAllOrders(String cusName,String year);
	
	/*
	 * 客户构成分析(默认显示)
	 */
	public List<CstCustomer> find(String type);
	
	/*
	 * 查询客户流失
	 */
	public List<CstLost> findAllCstLosts(String cusName,String managerName);
	
	
}
