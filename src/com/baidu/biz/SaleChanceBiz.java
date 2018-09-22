package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.form.SaleChanceForm;

public interface SaleChanceBiz {
	/*
	 * ��ѯ
	 */
	public List<SalChance>querySalchance(int pageSize,int curpage ,SaleChanceForm saleChanceForm);
	/*
	 * ���ҳ��
	 */
	public int MaxPage(int pageSize,SaleChanceForm saleChan);
	/*
	 * ת����ҳ
	 */
	public int getpage(SaleChanceForm salechan);
	/*
	 * ���
	 */
	public int AddSaleChance(SalChance salechan);
	/*
	 * ɾ��
	 */
	public int dateSaleCHance(int chcId);
	/*
	 * ��ѯ����
	 */
	public SalChance hiSal(int chcId);
	/*
	 * �޸�
	 */
	public int updateSale(SalChance sale);
	/*
	 * ����
	 */
	public int updateSaleHan(SalChance sale);
	/*
	 * �����ɹ�
	 */
	public int updateSal(SalChance salChance);
	/*
	 * ���
	 */
	public int AddCu(CstCustomer cstCustomer);
	
	
	public int getMax();
}
