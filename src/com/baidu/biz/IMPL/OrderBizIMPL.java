package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.OrderBiz;
import com.baidu.dao.OrderDao;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.CstLost;
import com.baidu.struts.entity.OrdersLine;

public class OrderBizIMPL implements OrderBiz{
	
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<OrdersLine> findAllOrders(String cusName,String year) {
		// TODO Auto-generated method stub
		return orderDao.findAllOrders(cusName,year);
	}

	@Override
	public List<CstCustomer> find(String type) {
		// TODO Auto-generated method stub
		return orderDao.find(type);
	}
	@Override
	public List<CstLost> findAllCstLosts(String cusName, String managerName) {
		// TODO Auto-generated method stub
		return orderDao.findAllCstLosts(cusName, managerName);
	}

}
