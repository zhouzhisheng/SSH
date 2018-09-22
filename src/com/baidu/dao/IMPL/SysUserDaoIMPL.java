package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.SysUserDao;
import com.baidu.struts.entity.SysUser;

public class SysUserDaoIMPL  extends HibernateDaoSupport implements SysUserDao{

	@Override
	public SysUser getUser(String usrName, String usrPassword) {
		String sql="from  SysUser where usrName='"+usrName+"' and usrPassword='"+usrPassword+"' ";
		SysUser sysUser=(SysUser) getSession().createQuery(sql).uniqueResult();
		return sysUser;
	}
	@Override
	public SysUser getuserPassword(String usrPassword) {
	 SysUser sys=(SysUser)getSession().load(SysUser.class, usrPassword);
		return sys;
		
	}
	@Override
	public List<SysUser> listsys() {
		String hql="from SysUser";
		List<SysUser>list=getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public SysUser getid(int useId) {
		SysUser sy=(SysUser)getSession().get(SysUser.class, useId);
		return sy;
	}
}
