package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public interface CstserviceBiz {
	
	/*
	 * ��ӿͻ�����
	 */
	public int addCstservice(CstService cstService);
	
	/*
	 * ��ѯ����鵵(��ҳ)
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * ��ѯ����鵵�ļ�¼
	 */
	public int getCount();
	
	/*
	 * ��ѯ����鵵�����ҳ��
	 */
	public int getMaxPage(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * ���ݱ�Ų�ѯ����鵵
	 */
	public CstService findByID(int ID);
	
	/*
	 * ��ת������Ҳ
	 */
	public int getSize(ServiceForm serviceForm);
	
	/*
	 * ��ѯ�ͻ��������
	 */
	public List<CstService> find(int year);
}
