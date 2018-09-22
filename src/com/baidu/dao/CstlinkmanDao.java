package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.CstLinkman;

public interface CstlinkmanDao {

	public   CstLinkman cstLing(int lkmId);
	
	public List<CstLinkman>cstLinkmans(String custNo);
	
	public int AddCslinKman(CstLinkman cstLinkman);
	
	public int dateCslink(int lkmId);
	
	public int updateCl(CstLinkman cstLinkman);
}
