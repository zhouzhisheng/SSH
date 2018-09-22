package com.baidu.dao.IMPL;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.CstCustomerDao;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.form.CstCustomerForm;

public class CstCustomerDaoIMPL extends HibernateDaoSupport implements CstCustomerDao{
	
	@Override
	public List<CstCustomer> querySalchance(int pageSize,int curpage,CstCustomerForm cForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("select s from CstCustomer s where 1=1");
		if(cForm.getCustName()!=null&& cForm.getCustName().length()>0){
			hql.append(" and custName like '%"+cForm.getCustName()+"%'");
		}
		if(cForm.getCustNo()!=null && cForm.getCustNo().length()>0){
			hql.append(" and custNo like '%"+cForm.getCustNo()+"%'");
		}
		if(cForm.getCustLevel()!=0){
			hql.append(" and custLevel="+cForm.getCustLevel());
		}
		if(cForm.getCustRegion()!=null && cForm.getCustRegion().trim().equals("全部")){
			hql.append(" and custRegion like '%"+cForm.getCustRegion()+"%'");
		}
		if(cForm.getCustStatus()!=0 && cForm.getCustStatus()<2){
			hql.append(" and custStatus="+cForm.getCustStatus());
		}
		List<CstCustomer>list=getSession().createQuery(hql.toString()).setFirstResult((curpage-1)*pageSize).setMaxResults(pageSize).list();
		return list;
	}
	@Override
	public int getMaxpage(int pageSize, CstCustomerForm cForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  CEILING(COUNT(*)*1.0/"+pageSize+") from CstCustomer c where 1=1");
		
		if(cForm.getCustName()!=null&& cForm.getCustName().length()>0){
			hql.append(" and c.custName like '%"+cForm.getCustName()+"%'");
		}
		if(cForm.getCustNo()!=null && cForm.getCustNo().length()>0){
			hql.append(" and c.custNo like '%"+cForm.getCustNo()+"%'");
		}
		if(cForm.getCustLevel()!=0){
			hql.append(" and c.custLevel="+cForm.getCustLevel());
		}
		if(cForm.getCustRegion()!=null && cForm.getCustRegion().trim().equals("全部")){
			hql.append(" and c.custRegion like '%"+cForm.getCustRegion()+"%'");
		}
		if(cForm.getCustStatus()!=0 && cForm.getCustStatus()<2){
			hql.append(" and custStatus="+cForm.getCustStatus());
		}
		double page=(Double)getSession().createQuery(hql.toString()).uniqueResult();
		int maxPage=(int)page;
		return maxPage;
	}
	@Override
	public int page(CstCustomerForm  cForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  COUNT(*)*1.0 from CstCustomer c where 1=1");
			if(cForm.getCustName()!=null&& cForm.getCustName().length()>0){
				hql.append(" and c.custName like '%"+cForm.getCustName()+"%'");
			}
			if(cForm.getCustNo()!=null && cForm.getCustNo().length()>0){
				hql.append(" and c.custNo like '%"+cForm.getCustNo()+"%'");
			}
			if(cForm.getCustLevel()!=0){
				hql.append(" and c.custLevel="+cForm.getCustLevel());
			}
			if(cForm.getCustRegion()!=null && cForm.getCustRegion().trim().equals("全部")){
				hql.append(" and c.custRegion like '%"+cForm.getCustRegion()+"%'");
			}
			if(cForm.getCustStatus()!=0 && cForm.getCustStatus()<2){
				hql.append(" and custStatus="+cForm.getCustStatus());
			}
			double page1=(Double)getSession().createQuery(hql.toString()).uniqueResult();
			int page=(int)page1;
		return page;
	}
	@Override
	public CstCustomer cs(String custNo) {
		CstCustomer cs=(CstCustomer)getSession().get(CstCustomer.class, custNo);
		return cs;
	}
	@Override
	public CstCustomer dateCstCustomer(String custNo) {
		CstCustomer cs=(CstCustomer)getSession().get(CstCustomer.class, custNo);
		cs.setCustStatus(3);
		return cs;
	}
	@Override
	public int updateCs(CstCustomer cs) {
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
