package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.SaleChanceDao;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.form.SaleChanceForm;

public class SaleChanceDaoIMPL extends HibernateDaoSupport implements SaleChanceDao{

	@Override//查询
	public List<SalChance> querySalchance(int pageSize,int  curpage ,SaleChanceForm saleChanceForm) {
		StringBuilder hql=new StringBuilder();
		hql.append("from SalChance where 1=1 ");
		//s,SalPlan a where s.chcId=a.salChance.chcId 
		if(saleChanceForm.getChcCustName()!=null && saleChanceForm.getChcCustName().length()>0){
			hql.append(" and chcCustName like '%"+saleChanceForm.getChcCustName()+"%'");
		}
		if(saleChanceForm.getChcLinkman()!=null && saleChanceForm.getChcLinkman().length()>0){
			hql.append(" and chcLinkman like '%"+saleChanceForm.getChcLinkman()+"%'");
		}
		if(saleChanceForm.getChcDesc()!=null && saleChanceForm.getChcDesc().length()>0){
			hql.append(" and chcDesc like '%"+saleChanceForm.getChcDesc()+"%'");
		}	
		if(saleChanceForm.getChcStatus()!=0 && saleChanceForm.getChcStatus()>0){
			hql.append(" and chcStatus="+saleChanceForm.getChcStatus()+" order by chcCreateDate desc");
		}
List<SalChance>salist=getSession().createQuery(hql.toString()).setFirstResult((curpage-1)*pageSize).setMaxResults(pageSize).list();

		return salist;
	}
	@Override//最大页数
	public int MaxPage(int pageSize, SaleChanceForm saleChan) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  CEILING(COUNT(*)*1.0/"+pageSize+")from SalChance where 1=1");
		if(saleChan.getChcCustName()!=null && saleChan.getChcCustName().length()>0){
			hql.append(" and chcCustName like '%"+saleChan.getChcCustName()+"%'");
		}
		if(saleChan.getChcLinkman()!=null && saleChan.getChcLinkman().length()>0){
			hql.append(" and chcLinkman like '%"+saleChan.getChcLinkman()+"%'");
		}
		if(saleChan.getChcDesc()!=null && saleChan.getChcDesc().length()>0){
			hql.append(" and chcDesc like '%"+saleChan.getChcDesc()+"%'");
		}
		if(saleChan.getChcStatus()!=0 && saleChan.getChcStatus()>0){
			hql.append(" and chcStatus="+saleChan.getChcStatus()+"");
		}
		double reglet=(Double) getSession().createQuery(hql.toString()).uniqueResult();
		int maxpage=(int)reglet;
		return maxpage;
	}

	@Override//转到页数
	public int getpage(SaleChanceForm salechan) {
		StringBuilder hql=new StringBuilder();
		hql.append("select  COUNT(*)*1.0 from SalChance where 1=1");
		if(salechan.getChcCustName()!=null && salechan.getChcCustName().length()>0){
			hql.append(" and chcCustName like '%"+salechan.getChcCustName()+"%'");
		}
		if(salechan.getChcLinkman()!=null && salechan.getChcLinkman().length()>0){
			hql.append(" and chcLinkman like '%"+salechan.getChcLinkman()+"%'");
		}
		if(salechan.getChcDesc()!=null && salechan.getChcDesc().length()>0){
			hql.append(" and chcDesc like '%"+salechan.getChcDesc()+"%'");
		}
		if(salechan.getChcStatus()!=0 && salechan.getChcStatus()>0){
			hql.append(" and chcStatus="+salechan.getChcStatus()+"");
		}
		double page=(Double) getSession().createQuery(hql.toString()).uniqueResult();
		int cpage=(int) page;
		return cpage;
	}
	@Override//添加
	public int AddSaleChance(SalChance salechan) {
		int rwo=1;
		try{
			getSession().save(salechan);
		}catch(Exception e){
			e.printStackTrace();
			rwo=0;
		}
		return rwo;
	}
	@Override//删除
	public int dateSaleCHance(int chcId) {
		int rwo=1;
		try{
		SalChance sal=(SalChance) getSession().get(SalChance.class, chcId);
		getSession().delete(sal);	
		}catch(Exception e){
			e.printStackTrace();
			rwo=0;
		}
		return rwo;
	}
	@Override//查询单个
	public SalChance hiSal(int chcId) {
		SalChance salchance=(SalChance)getSession().get(SalChance.class, chcId);
		return salchance;
	}
	@Override//修改
	public int updateSale(SalChance sale) {
		int co=1;//成功
		try{
			getSession().update(sale);
			
		}catch(Exception e){
			e.printStackTrace();
			co=0;//失败
		}
		return co;
	}
	@Override//分配
	public int updateSaleHan(SalChance sale) {
		int  rwo=1;
		try{
			getSession().update(sale);
		}catch(Exception e){
			e.printStackTrace();
			rwo=0;
		}
		return rwo;
	}
	@Override
	public int updateSal(SalChance sal) {
		int ci=1;
		try{
			getSession().update(sal);
		}catch(Exception e){
			e.printStackTrace(); ci=0;
		}
		return ci;
	}
	@Override
	public int AddCu(CstCustomer cstCustomer) {
		int co=1;
		try{
			getSession().save(cstCustomer);
		}catch(Exception e){
			e.printStackTrace(); co=0;
		}
		return co;
	}
	@Override
	public int getMax() {
		double max=(Double)getSession().createQuery("select COUNT(*)*1.0 from CstCustomer").uniqueResult();
		int maxpage=(int )max;
		return maxpage;
	}

}
