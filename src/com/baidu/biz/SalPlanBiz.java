package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.SalChance;
import com.baidu.struts.entity.SalPlan;
import com.baidu.struts.form.SalPlanForm;

public interface SalPlanBiz {

	public List<SalChance>SalPale(int pageSize,int curpage,SalPlanForm salplanForm, int plan);//查询
	public int maxPage(int pageSize,SalPlanForm salplanForm,int plan);//最大页数
	public int page(SalPlanForm salplanForm,int paln);//
	public SalChance salPale(int chcId);//
	public SalPlan salist(int chcId);//
	public int AddSalPlan(SalPlan salPlan);//
	public List<SalPlan> list(int chcId);//
	public int Add(SalPlan salPlan);
	public int date(int  plaId);//删除
}
