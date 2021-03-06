package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.form.SaleChanceForm;

public interface SaleChanceDao {

	/*
	 * 查询
	 */
	public List<SalChance>querySalchance(int pageSize,int curpage ,SaleChanceForm saleChanceForm);
	/*
	 * 最大页数
	 */
	public int MaxPage(int pageSize,SaleChanceForm saleChan);
	
	/*
	 * 查询转到页数
	 */
	public int getpage(SaleChanceForm salechan);
	
	/*
	 * 添加
	 */
	public int AddSaleChance(SalChance salechan);
	
	/*
	 * 删除
	 */
	public int dateSaleCHance(int chcId );
	/*
	 * 查询单数
	 */
	public SalChance hiSal(int chcId);
	/*
	 * 修改
	 */
	public int updateSale(SalChance sale);
	/*
	 * 分配
	 */
	public int updateSaleHan(SalChance sale);
	/*
	 * 开发成功
	 */
	public int updateSal(SalChance sal);
	/*
	 * 添加
	 */
	public int AddCu(CstCustomer cstCustomer);
	
	public int getMax();
}
