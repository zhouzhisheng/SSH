package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.BasDict;
import com.baidu.struts.form.BasdictForm;

public interface BasdictBiz {


	/*
	 * ��ѯ�����ֵ����
	 */
	public List<BasDict> findAllBasDicts(BasdictForm basdictForm);
	
	/*
	 * ��������ֵ�
	 */
	public int addbasDict(BasDict basDict);
	
	/*
	 * ���ݱ�Ų�ѯ�����ֵ�
	 */
	public BasDict findByID(int dict_id);
	
	/*
	 * �޸������ֵ�
	 */
	public int updatebasdict(BasDict basDict);
	
	/*
	 * ɾ�������ֵ�
	 */
	public int deletebasdict(int dict_id);
}
