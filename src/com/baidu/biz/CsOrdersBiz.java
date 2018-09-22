package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.Orders;
import com.baidu.struts.entity.OrdersLine;
import com.baidu.struts.entity.Product;
import com.baidu.struts.form.CstCustomerForm;

public interface CsOrdersBiz {

    public List<Orders>Orders(int pageSize,int curpage);
	
	public int MaxPage(int pageSize,CstCustomerForm saleChan);
	
	public List<Orders> OrD();
	
    public OrdersLine orLing(int odrId);
	
	public List<OrdersLine> oo(int oddId);
	
	public List<Product> pr(int oddId);
	
	public int getCount(String name);
	
	public int page(CstCustomerForm cForm);
}
