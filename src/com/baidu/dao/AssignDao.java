package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.entity.SysUser;
import com.baidu.struts.form.ServiceForm;

public interface AssignDao {

	/*
	 * ��ѯ�������
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
	 * ��ѯ����ϵͳ�û�
	 */
	public List<SysUser> findAll();
	
	/*
	 * �������
	 */
	public int updateCstservice(CstService cstService);
	
	/*
	 * ���ݱ�Ų�ѯϵͳ�û�
	 */
	public SysUser findByID(int id);
	
	/*
	 * ���ݱ��ѯ����
	 */
	public CstService getByID(int id);
	
	/*
	 * ɾ���������
	 */
	public int delete(int id);
}
