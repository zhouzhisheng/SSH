package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstActivity;

public interface ActivityBiz {

public   CstActivity cstLing(int atvId);
	
	public List<CstActivity>cstLinkmans(String custNo);
	
	public int AddCslinKman(CstActivity activity);
	
	public int dateCslink(int atvId);
	
	public int updateCl(CstActivity CstActivity);
}
