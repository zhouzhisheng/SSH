package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.SaleChanceBiz;
import com.baidu.dao.SaleChanceDao;
import com.baidu.dao.IMPL.SaleChanceDaoIMPL;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.form.SaleChanceForm;

public class SaleChanceBizIMPL implements SaleChanceBiz{

	private  SaleChanceDao SaleChance;
	
	public void setSaleChance(SaleChanceDao saleChance) {
		SaleChance = saleChance;
	}
	@Override
	public List<SalChance> querySalchance(int pageSize, int curpage,
			SaleChanceForm saleChanceForm) {
		return SaleChance.querySalchance(pageSize, curpage, saleChanceForm);
	}
	@Override
	public int MaxPage(int pageSize, SaleChanceForm saleChan) {
	
		return SaleChance.MaxPage(pageSize, saleChan);
	}
	@Override
	public int getpage(SaleChanceForm salechan) {
		return SaleChance.getpage(salechan);
	}


	@Override
	public int AddSaleChance(SalChance salechan) {
		return SaleChance.AddSaleChance(salechan);
	}


	@Override
	public int dateSaleCHance(int chcId) {
		return SaleChance.dateSaleCHance(chcId);
	}


	@Override
	public SalChance hiSal(int chcId) {
		return SaleChance.hiSal(chcId);
	}
	@Override
	public int updateSale(SalChance sale) {
		return SaleChance.updateSale(sale);
	}
	@Override
	public int updateSaleHan(SalChance sale) {
		return SaleChance.updateSaleHan(sale);
	}
	@Override
	public int updateSal(SalChance sal) {
		return SaleChance.updateSal(sal);
	}
	@Override
	public int AddCu(CstCustomer cstCustomer) {
		return SaleChance.AddCu(cstCustomer);
	}
	@Override
	public int getMax() {
		return SaleChance.getMax();
	}

}
