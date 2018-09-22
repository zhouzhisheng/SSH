package com.baidu.biz;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.form.CstCustomerForm;

public interface CstCustomerBiz {

public List<CstCustomer>querySalchance(int pageSize,int curpage,CstCustomerForm csForm);//分页查询
	
	public int getMaxpage(int pageSize,CstCustomerForm cForm);//最大页数
	
	public int page(CstCustomerForm cForm);
	
	public CstCustomer cs(String custNo);
	
	public CstCustomer dateCstCustomer(String custNo);
	
	public int updateCs(CstCustomer cs);
}
