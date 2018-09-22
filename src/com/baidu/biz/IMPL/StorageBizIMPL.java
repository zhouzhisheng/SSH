package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.StorageBiz;
import com.baidu.dao.StorageDao;
import com.baidu.struts.entity.Storage;
import com.baidu.struts.form.StorageForm;

public class StorageBizIMPL implements StorageBiz{

	private StorageDao storageDao;
	public void setStorageDao(StorageDao storageDao) {
		this.storageDao = storageDao;
	}
	@Override
	public List<Storage> findAllStorages(int curPage, int pageSize,
			StorageForm storageForm) {
		// TODO Auto-generated method stub
		return storageDao.findAllStorages(curPage, pageSize, storageForm);
	}
	@Override
	public int getMaxPage(int curPage, int pageSize, StorageForm storageForm) {
		// TODO Auto-generated method stub
		return storageDao.getMaxPage(curPage, pageSize, storageForm);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return storageDao.getCount();
	}
	@Override
	public int getSize(StorageForm storageForm) {
		// TODO Auto-generated method stub
		return storageDao.getSize(storageForm);
	}
}
