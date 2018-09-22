package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstLost;
import com.baidu.struts.form.CstCustomerForm;

public interface CstlostBiz {

	public List<CstLost>CLost(int pageSize,int curPage,CstCustomerForm cForm);
	
	public int getMapg(int pageSize,CstCustomerForm csForm);
	
	public int page(CstCustomerForm cForm);
	
	public CstLost CuLost(int lstId);
	
	public int AddCstLost(CstLost cs);
	
	public int updateCstLost(CstLost cs);
}
