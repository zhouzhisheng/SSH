package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.SalPlanBiz;
import com.baidu.dao.SalPlanDao;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.entity.SalPlan;
import com.baidu.struts.form.SalPlanForm;

public class SalPlanBizIMPL  implements SalPlanBiz{

	private SalPlanDao salPlandao;
	
	public void setSalPlandao(SalPlanDao salPlandao) {
		this.salPlandao = salPlandao;
	}

	@Override
	public List<SalChance> SalPale(int pageSize, int curpage,
			SalPlanForm salplanForm,int plan) {
		return salPlandao.SalPale(pageSize, curpage, salplanForm, plan);
	}

	@Override
	public int maxPage(int pageSize, SalPlanForm salplanForm,int plan) {
		return salPlandao.maxPage(pageSize, salplanForm, plan);
	}

	@Override
	public int page(SalPlanForm salplanForm,int plan) {
		return salPlandao.page(salplanForm, plan);
	}

	@Override
	public SalChance salPale(int chcId) {
		return salPlandao.salPale(chcId);
	}

	@Override
	public SalPlan salist(int chcId){
		return salPlandao.salist(chcId);
	}

	@Override
	public int AddSalPlan(SalPlan salPlan){
		return salPlandao.AddSalPlan(salPlan);
	}

	@Override
	public List<SalPlan> list(int chcId) {
		return salPlandao.list(chcId);
	}

	@Override
	public int Add(SalPlan salPlan) {
		// TODO Auto-generated method stub
		return salPlandao.Add(salPlan);
	}

	@Override
	public int date(int  plaId) {
		return salPlandao.date(plaId);
	}

	

}
