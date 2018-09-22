package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.CstlinkmanDao;
import com.baidu.struts.entity.CstLinkman;

public final class CstlinkmanDaoIMPL extends HibernateDaoSupport implements CstlinkmanDao{

	@Override
	public   CstLinkman cstLing(int lkmId) {
		return (CstLinkman) getSession().get(CstLinkman.class, lkmId);
	}
	@Override
	public List<CstLinkman> cstLinkmans(String custNo) {
		return getSession().createQuery("from CstLinkman where cstCustomer.custNo='"+custNo+"'").list();
	}
	@Override
	public int AddCslinKman(CstLinkman cstLinkman) {
		int rw=1;
		try{
			getSession().save(cstLinkman);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rw;
	}
	@Override
	public int dateCslink(int lkmId) {
		int cc=1;
		try{
		CstLinkman cs=(CstLinkman)getSession().get(CstLinkman.class, lkmId);
			getSession().delete(cs);
		}catch(Exception e){
			e.printStackTrace();
			cc=0;
		}
		return cc;
	}
	@Override
	public int updateCl(CstLinkman cstLinkman) {
    int cc=1;
		try{
			getSession().update(cstLinkman);
		}catch(Exception e){
			e.printStackTrace();
			cc=0;
		}
		return cc;
	}

}
