package com.baidu.dao;

import java.util.List;

import com.baidu.struts.entity.Storage;
import com.baidu.struts.form.StorageForm;

public interface StorageDao {

	/*
	 * 查询库存
	 */
	public List<Storage> findAllStorages(int curPage, int pageSize,StorageForm storageForm);
	
	/*
	 * 查询最大页数
	 */
	public int getMaxPage(int curPage, int pageSize, StorageForm storageForm); 
	
	/*
	 * 查询记录
	 */
	public int getCount();
	
	/*
	 * 跳转到多少也
	 */
	public int getSize(StorageForm storageForm);
}
