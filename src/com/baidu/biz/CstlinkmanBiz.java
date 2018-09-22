package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstLinkman;

public interface CstlinkmanBiz {

	public   CstLinkman cstLing(int lkmId);
	
	public List<CstLinkman> cstLinkmans(String custNo);
	
	public int AddCslinKman(CstLinkman cstLinkman);
	
	public int dateCslink(int lkmId);

	public int updateCl(CstLinkman cstLinkman);
}
