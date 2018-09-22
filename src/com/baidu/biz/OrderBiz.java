package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.CstLost;
import com.baidu.struts.entity.OrdersLine;

public interface OrderBiz {

	/*
	 * ��ѯ�ͻ�����
	 */
	public List<OrdersLine> findAllOrders(String cusName,String year);
	
	/*
	 * �ͻ����ɷ���(Ĭ����ʾ)
	 */
	public List<CstCustomer> find(String type);
	
	/*
	 * ��ѯ�ͻ���ʧ
	 */
	public List<CstLost> findAllCstLosts(String cusName,String managerName);
	
	
}
