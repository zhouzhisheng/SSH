package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.SysUser;

public interface SysUserDao {

	/*
	 * 判断用户名,密码实现登录
	 */
	public SysUser getUser(String usrName,String usrPassword );
	
	/*
	 * 根据数据库加密的密码,和输入的密码进行比较,判断是否相等,实现登录成功
	 */
	public SysUser getuserPassword(String usrPassword);
	
	/*
	 * 查询
	 */
	public List<SysUser>listsys();
	/*
	 * 
	 */
	public SysUser getid(int useId);
}
