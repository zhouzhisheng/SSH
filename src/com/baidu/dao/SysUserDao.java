package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.SysUser;

public interface SysUserDao {

	/*
	 * �ж��û���,����ʵ�ֵ�¼
	 */
	public SysUser getUser(String usrName,String usrPassword );
	
	/*
	 * �������ݿ���ܵ�����,�������������бȽ�,�ж��Ƿ����,ʵ�ֵ�¼�ɹ�
	 */
	public SysUser getuserPassword(String usrPassword);
	
	/*
	 * ��ѯ
	 */
	public List<SysUser>listsys();
	/*
	 * 
	 */
	public SysUser getid(int useId);
}
