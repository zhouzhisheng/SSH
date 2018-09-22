package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.CsOrdersBiz;
import com.baidu.dao.CsOrdersDao;
import com.baidu.struts.entity.OrdersLine;
import com.baidu.struts.entity.Product;
import com.baidu.struts.form.CstCustomerForm;

public class CsOrdersBizIMPL implements CsOrdersBiz{

	private CsOrdersDao csOrders;
	public void setCsOrders(CsOrdersDao csOrders) {
		this.csOrders = csOrders;
	}

	@Override
	public List<com.baidu.struts.entity.Orders> Orders(int pageSize, int curpage) {
		return csOrders.Orders(pageSize, curpage);
	}
	@Override
	public int MaxPage(int pageSize, CstCustomerForm saleChan) {
		return csOrders.MaxPage(pageSize, saleChan);
	}

	@Override
	public List<com.baidu.struts.entity.Orders> OrD() {
		return csOrders.OrD();
	}

	@Override
	public OrdersLine orLing(int odrId) {
		return csOrders.orLing(odrId);
	}

	@Override
	public List<OrdersLine> oo(int oddId) {
		return csOrders.oo(oddId);
	}

	@Override
	public List<Product> pr(int oddId) {
		return csOrders.pr(oddId);
	}

	@Override
	public int getCount(String name) {
		return csOrders.getCount(name);
	}

	@Override
	public int page(CstCustomerForm cForm) {
		return csOrders.page(cForm);
	}

	
	
}
