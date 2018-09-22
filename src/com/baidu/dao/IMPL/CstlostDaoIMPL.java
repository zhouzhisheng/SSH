package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.CstlostDao;
import com.baidu.struts.entity.CstLost;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.form.CstCustomerForm;

public class CstlostDaoIMPL  extends HibernateDaoSupport implements CstlostDao{

	@Override
	public List<CstLost> CLost(int pageSize, int curPage, CstCustomerForm cForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("from CstLost where 1=1");
		if(cForm.getLstCustName()!=null && cForm.getLstCustName().length()>0){
			hql.append(" and lstCustName like '%"+cForm.getLstCustName()+"%'");
		}
		if(cForm.getLstCustManagerName()!=null && cForm.getLstCustManagerName().length()>0){
			hql.append(" and lstCustManagerName like '%"+cForm.getLstCustManagerName()+"%'");
		}
List<CstLost>list=getSession().createQuery(hql.toString()).setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize).list();
		return list;
	}
	@Override
	public int getMapg(int pageSize, CstCustomerForm csForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  CEILING(COUNT(*)*1.0/"+pageSize+") from CstLost where 1=1");
		
		if(csForm.getLstCustName()!=null && csForm.getLstCustName().length()>0){
			hql.append(" and  lstCustName like '%"+csForm.getLstCustName()+"%'");
		}
		if(csForm.getLstCustManagerName()!=null && csForm.getLstCustManagerName().length()>0){
			hql.append(" and lstCustManagerName like '%"+csForm.getLstCustManagerName()+"%'");
		}
		double page=(Double)getSession().createQuery(hql.toString()).uniqueResult();
		int maxPage=(int)page;
		return maxPage;
	}

	@Override
	public int page(CstCustomerForm cForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("select COUNT(*)*1.0 from CstLost s where 1=1");
		
		if(cForm.getLstCustName()!=null && cForm.getLstCustName().length()>0){
			hql.append(" and s.lstCustName like '%"+cForm.getLstCustName()+"%'");
		}
		if(cForm.getLstCustManagerName()!=null && cForm.getLstCustManagerName().length()>0){
			hql.append(" and s.lstCustManagerName like '%"+cForm.getLstCustManagerName()+"%'");
		}
		double page1=(Double)getSession().createQuery(hql.toString()).uniqueResult();
		int page=(int)page1;
		return page;
	}
	@Override
	public CstLost CuLost(int lstId) {
		String hql=" from CstLost where lstId="+lstId;
		CstLost list=(CstLost)getSession().createQuery(hql).uniqueResult();
		return list;
	}
	@Override
	public int AddCstLost(CstLost cs) {
		int cw=1;
		try{
			getSession().update(cs);
		}catch(Exception e){
			e.printStackTrace();
			cw=0;
		}
		return cw;
	}
	@Override
	public int updateCstLost(CstLost cs) {
		
		int cw=1;
		try{
			getSession().update(cs);
		}catch(Exception e){
			e.printStackTrace();
			cw=0;
		}
		return cw;
	}
	
}
