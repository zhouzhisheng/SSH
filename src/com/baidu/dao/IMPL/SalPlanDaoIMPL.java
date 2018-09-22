package com.baidu.dao.IMPL;

import java.util.List;

import org.hibernate.dialect.SAPDBDialect;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.SalPlanDao;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.entity.SalPlan;
import com.baidu.struts.form.SalPlanForm;

public class SalPlanDaoIMPL extends HibernateDaoSupport implements SalPlanDao{

	@Override
	public List<SalChance> SalPale(int pageSize,int curpage,SalPlanForm salplanForm,int paln) {
		StringBuilder hql=new StringBuilder();
		hql.append("select s from SalChance s where 1=1");
		
		if(salplanForm.getChcCustName()!=null && salplanForm.getChcCustName().length()>0){
			hql.append(" and s.chcCustName like '%"+salplanForm.getChcCustName()+"%'");
		}
		if(salplanForm.getChcLinkman()!=null && salplanForm.getChcLinkman().length()>0){
			hql.append(" and s.chcLinkman like '%"+salplanForm.getChcLinkman()+"%'");
		}
		if(salplanForm.getChcTitle()!=null && salplanForm.getChcTitle().length()>0){
			hql.append(" and s.chcTitle like '%"+salplanForm.getChcTitle()+"%'");
		}
		if(paln==2){
			hql.append(" and s.chcStatus>1");
			if(salplanForm!=null){
				if(salplanForm.getChcStatus()!=null && salplanForm.getChcStatus().equals("1")){
					hql.append("  and s.chcStatus="+salplanForm.getChcStatus());
				}
			}
		}
	List<SalChance>list=getSession().createQuery(hql.toString()).setFirstResult((curpage-1)*pageSize).setMaxResults(pageSize).list();
		return list;
	}
	@Override
	public int maxPage(int pageSize, SalPlanForm salplanForm,int plan ) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  CEILING(COUNT(*)*1.0/"+pageSize+") from SalChance s where 1=1");
		
		if(salplanForm.getChcCustName()!=null && salplanForm.getChcCustName().length()>0){
			hql.append(" and s.chcCustName like '%"+salplanForm.getChcCustName()+"%'");
		}
		if(salplanForm.getChcLinkman()!=null && salplanForm.getChcLinkman().length()>0){
			hql.append(" and s.chcLinkman like '%"+salplanForm.getChcLinkman()+"%'");
		}
		if(salplanForm.getChcTitle()!=null && salplanForm.getChcTitle().length()>0){
			hql.append(" and  s.chcTitle like '%"+salplanForm.getChcTitle()+"%'");
		}
		if(plan==2){
			hql.append(" and s.chcStatus>1");
			if(salplanForm!=null){
				if(salplanForm.getChcStatus()!=null && salplanForm.getChcStatus().equals("1")){
					hql.append(" and s.chcStatus="+salplanForm.getChcStatus());
				}
			}
		}
		double page=(Double)getSession().createQuery(hql.toString()).uniqueResult();
		int maxPage=(int)page;
		return maxPage;
	}
	@Override
	public int page(SalPlanForm salplanForm,int plan) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  COUNT(*)*1.0 from SalChance s where 1=1");
		
		if(salplanForm.getChcCustName()!=null && salplanForm.getChcCustName().length()>0){
			hql.append(" and s.chcCustName like '%"+salplanForm.getChcCustName()+"%'");
		}
		if(salplanForm.getChcLinkman()!=null && salplanForm.getChcLinkman().length()>0){
			hql.append(" and s.chcLinkman like '%"+salplanForm.getChcLinkman()+"%'");
		}
		if(salplanForm.getChcTitle()!=null && salplanForm.getChcTitle().length()>0){
			hql.append(" and  s.chcTitle like '%"+salplanForm.getChcTitle()+"%'");
		}
		if(plan==2){
			hql.append(" and s.chcStatus>1");
			if(salplanForm!=null){
				if(salplanForm.getChcStatus()!=null && salplanForm.getChcStatus().equals("1")){
					hql.append(" and s.chcStatus="+salplanForm.getChcStatus());
				}
			}
		}
		double page1=(Double)getSession().createQuery(hql.toString()).uniqueResult();
		int page=(int)page1;
		return page;
	}
	@Override
	public SalChance salPale(int chcId) {
    SalChance sal=(SalChance)getSession().get(SalChance.class, chcId);
		return sal;
	}
	@Override
	public SalPlan salist(int chcId) {
	 SalPlan sal=(SalPlan)getSession().get(SalPlan.class, chcId);
		return sal;
	}
	@Override
	public int AddSalPlan(SalPlan salPlan){
		int co=1;
		try{
			getSession().update(salPlan);
		}catch(Exception e){
			e.printStackTrace();
			co=0;
		}
		return co;
	}
	@Override
	public List<SalPlan> list(int chcId) {
		return getSession().createQuery(" from SalPlan where salChance.chcId="+chcId).list();
	}
	@Override
	public int Add(SalPlan salPlan) {
		// TODO Auto-generated method stub
		int co=1;
		try{
			getSession().save(salPlan);
		}catch(Exception e){
			e.printStackTrace(); co=0;
		}
		return co;
	}
	@Override
	public int date(int  plaId) {
   int co=1;
   try{
	 SalPlan sal=(SalPlan)getSession().get(SalPlan.class, plaId);
	 getSession().delete(sal);
   }catch(Exception e){
	   e.printStackTrace(); co=0;
   }
		return co;
	}
	
}
