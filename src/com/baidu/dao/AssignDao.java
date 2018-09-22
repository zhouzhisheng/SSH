package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.CstService;
import com.baidu.struts.entity.SysUser;
import com.baidu.struts.form.ServiceForm;

public interface AssignDao {

	/*
	 * 查询服务分配
	 */
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm);
	
	/*
	 * 查询最大页数
	 */
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm); 
	
	/*
	 * 查询记录
	 */
	public int getCount();
	
	/*
	 * 跳转到多少也
	 */
	public int getSize(ServiceForm serviceForm);
	
	/*
	 * 查询所有系统用户
	 */
	public List<SysUser> findAll();
	
	/*
	 * 服务分配
	 */
	public int updateCstservice(CstService cstService);
	
	/*
	 * 根据编号查询系统用户
	 */
	public SysUser findByID(int id);
	
	/*
	 * 根据编查询对象
	 */
	public CstService getByID(int id);
	
	/*
	 * 删除服务分配
	 */
	public int delete(int id);
}
