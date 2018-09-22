package com.baidu.biz;

import java.util.List;

import com.baidu.struts.entity.BasDict;
import com.baidu.struts.form.BasdictForm;

public interface BasdictBiz {


	/*
	 * 查询数据字典管理
	 */
	public List<BasDict> findAllBasDicts(BasdictForm basdictForm);
	
	/*
	 * 添加数据字典
	 */
	public int addbasDict(BasDict basDict);
	
	/*
	 * 根据编号查询数据字典
	 */
	public BasDict findByID(int dict_id);
	
	/*
	 * 修改数据字典
	 */
	public int updatebasdict(BasDict basDict);
	
	/*
	 * 删除数据字典
	 */
	public int deletebasdict(int dict_id);
}
