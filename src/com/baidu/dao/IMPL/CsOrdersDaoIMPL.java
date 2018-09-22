package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.baidu.struts.entity.Orders;
import com.baidu.struts.entity.OrdersLine;
import com.baidu.struts.entity.Product;
import com.baidu.dao.CsOrdersDao;
import com.baidu.struts.form.CstCustomerForm;

public class CsOrdersDaoIMPL extends HibernateDaoSupport implements CsOrdersDao{

	@Override//查询
	public List<Orders> Orders(int pageSize,int curpage) {
	 String hql=" from Orders";
	return getSession().createQuery(hql).setFirstResult((curpage-1)*pageSize).setMaxResults(pageSize).list();
	}
	@Override//最大页数
	public int MaxPage(int pageSize, CstCustomerForm saleChan) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  CEILING(COUNT(*)*1.0/"+pageSize+")from Orders");
		double reglet=(Double) getSession().createQuery(hql.toString()).uniqueResult();
		int maxPage=(int)reglet;
		return maxPage;
	}
	@Override
	public List<Orders> OrD() {
		String hql=" from Orders";
		return getSession().createQuery(hql).list();
	}
	@Override
	public OrdersLine orLing(int odrId) {
		OrdersLine or=(OrdersLine)getSession().get(OrdersLine.class, odrId);
		return or;
	}
	@Override
	public List<OrdersLine> oo(int oddId) {
		String hql=" from OrdersLine where odd_prod_id="+oddId;
		List<OrdersLine>list=getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public List<Product> pr(int oddId) {
		String hql="from Product where prodId="+oddId;
		List<Product>list=getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public int getCount(String name) {
		String hql="select COUNT(o) from Orders o where o.odrCustomer='"+name+"'";
		System.out.println(hql);
	double page1=(Double) getSession().createQuery(hql).uniqueResult();
	int page=(int)page1;
		return page;
	}
	@Override
	public int page(CstCustomerForm cForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("select COUNT(*)*1.0 from Orders");
		double reglet=(Double) getSession().createQuery(hql.toString()).uniqueResult();
		int page=(int)reglet;
		return page;
	}
	
}
