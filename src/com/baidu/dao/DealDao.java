package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public interface DealDao {

	/*
	 * ��ѯ������
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * ��ѯ���ҳ��
	 */
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm); 

	/*
	 * ��ѯ��¼
	 */
	public int getCount();
	
	/*
	 * ��ת������Ҳ
	 */
	public int getSize(ServiceForm serviceForm);
	
	/*
	 * ���ݱ�Ų�ѯ���������Ϣ
	 */
	public CstService ByID(int id);
	
	/*
	 * ��ӷ�������Ϣ
	 */
	public int uodateCstservice(CstService cstService);
}
