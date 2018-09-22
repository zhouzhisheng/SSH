package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.ActivityDao;
import com.baidu.struts.entity.CstActivity;
import com.baidu.struts.entity.CstLinkman;

public class CstActivityDaoIMPL  extends HibernateDaoSupport implements ActivityDao{

	@Override
	public CstActivity cstLing(int atvId) {
		return (CstActivity) getSession().get(CstActivity.class,atvId);
	}

	@Override
	public List<CstActivity> cstLinkmans(String custNo) {
		return getSession().createQuery("from CstActivity where cstCustomer.custNo='"+custNo+"'").list();
	}

	@Override
	public int AddCslinKman(CstActivity activity) {
		int cw=1;
		try{
			getSession().save(activity);
		}catch(Exception e){
			e.printStackTrace();
			cw=0;
		}
		return cw;
	}

	@Override
	public int dateCslink(int atvId) {
		int cw=1;
		try{
		CstActivity cs=(CstActivity)getSession().get(CstActivity.class, atvId);
			getSession().delete(cs);
		}catch(Exception e){
			e.printStackTrace();
			cw=0;
		}
		return cw;
	}

	@Override
	public int updateCl(CstActivity CstActivity) {
		int cc=1;
		try{
			getSession().update(CstActivity);
		}catch(Exception e){
			e.printStackTrace();
			cc=0;
		}
		return cc;
	}

}
