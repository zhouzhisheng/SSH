package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.SysUserBiz;
import com.baidu.dao.SysUserDao;
import com.baidu.dao.IMPL.SysUserDaoIMPL;
import com.baidu.struts.entity.SysUser;

public class SysUserBizIMPL implements SysUserBiz{

	private SysUserDao SysUserDao;
	
	public void setSysUserDao(SysUserDao sysUserDao) {
		SysUserDao = sysUserDao;
	}
	@Override
	public SysUser getUser(String usrName, String usrPassword) {
		return SysUserDao.getUser(usrName, usrPassword);
	}
	@Override
	public SysUser getuserPassword(String usrPassword) {
		return SysUserDao.getuserPassword(usrPassword);
	}
	@Override
	public List<SysUser> listsys() {
		return SysUserDao.listsys();
	}
	@Override
	public SysUser getid(int useId) {
		return SysUserDao.getid(useId);
	}
}
