package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.Storage;
import com.baidu.struts.form.StorageForm;

public interface StorageBiz {

	/*
	 * ��ѯ���
	 */
	public List<Storage> findAllStorages(int curPage, int pageSize,StorageForm storageForm);
	
	/*
	 * ��ѯ���ҳ��
	 */
	public int getMaxPage(int curPage, int pageSize, StorageForm storageForm); 
	
	/*
	 * ��ѯ��¼
	 */
	public int getCount();
	
	/*
	 * ��ת������Ҳ
	 */
	public int getSize(StorageForm storageForm);
}
