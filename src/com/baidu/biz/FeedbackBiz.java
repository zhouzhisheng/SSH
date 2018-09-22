package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public interface FeedbackBiz {

		/*
	 * ��ѯ������
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * ���ݱ�Ų�ѯ������
	 */
	public CstService findByID(int id);
	
	/*
	 * ��ӷ������Ľ���������
	 */
	public int updateCstservice(CstService cstService);
	
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
}
