package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.SysUser;

public interface SysUserBiz {

	/*
	 * �ж��û���,����ʵ�ֵ�¼
	 */
	public SysUser getUser(String usrName,String usrPassword );
	
	/*
	 * �������ݿ���ܵ�����,�������������бȽ�,�ж��Ƿ����,ʵ�ֵ�¼�ɹ�
	 */
	public SysUser getuserPassword(String usrPassword);
	
	public List<SysUser>listsys();
	
	public SysUser getid(int useId);
}
