package com.baidu.biz.IMPL;

import java.util.List;

import com.baidu.biz.ActivityBiz;
import com.baidu.dao.ActivityDao;
import com.baidu.struts.entity.CstActivity;

public class ActivityBizIMPL implements ActivityBiz{

	private ActivityDao actvitydao;
	public void setActvitydao(ActivityDao actvitydao) {
		this.actvitydao = actvitydao;
	}

	@Override
	public CstActivity cstLing(int atvId) {
		return actvitydao.cstLing(atvId);
	}

	@Override
	public List<CstActivity> cstLinkmans(String custNo) {
		return actvitydao.cstLinkmans(custNo);
	}

	@Override
	public int AddCslinKman(CstActivity activity) {
		return actvitydao.AddCslinKman(activity);
	}
	@Override
	public int dateCslink(int atvId) {
		return actvitydao.dateCslink(atvId);
	}

	@Override
	public int updateCl(CstActivity CstActivity) {
		return actvitydao.updateCl(CstActivity);
	}
	
}
