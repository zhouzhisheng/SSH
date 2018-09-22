package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.DealDao;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public class DealDaoIMPL extends HibernateDaoSupport implements DealDao{

	@Override
	public List<CstService> findCstServices(int curPage, int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("from CstService where svrStatus='已分配'");
		/*
		 * 客户名称
		 */
		if (serviceForm.getCusName() != null
				&& serviceForm.getCusName().trim() != "") {
			stringBuffer.append(" and svrCustName like '%"
					+ serviceForm.getCusName() + "%'");
		}
		/*
		 * 概要
		 */
		if (serviceForm.getTitle() != null
				&& serviceForm.getTitle().trim() != "") {
			stringBuffer.append(" and svrTitle like '%"
					+ serviceForm.getTitle() + "%'");
		}
		/*
		 * 服务类型
		 */
		if (serviceForm.getServiceType() != null && serviceForm.getServiceType() .trim()!="") {
			stringBuffer.append(" and svrType='" + serviceForm.getServiceType()
					+ "'");
		}
		/*
		 * 创建时间
		 */
		if (serviceForm.getDay1() != null && serviceForm.getDay1().trim() != "") {
			stringBuffer.append(" and DATEPART(YEAR,svrCreateDate)>="
					+ serviceForm.getDay1());
		}
		if (serviceForm.getDay2() != null && serviceForm.getDay2().trim() != "") {
			stringBuffer.append(" and DATEPART(YEAR,svrCreateDate)<="
					+ serviceForm.getDay2());
		}
		/*
		 * 状态
		 */
		if (serviceForm.getStatus() != null && serviceForm.getStatus().trim() != "") {
			stringBuffer.append(" and svrStatus='" + serviceForm.getStatus()+ "'");
		}
		List<CstService> list = getSession().createQuery(stringBuffer.toString())
				.setFirstResult((curPage - 1) * pageSize)
				.setMaxResults(pageSize).list();
		return list;
	}

	@Override
	public int getMaxPage(int curPage, int pageSize, ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0/" + pageSize
				+ ") from CstService where svrStatus='已分配'");
		/*
		 * 客户名称
		 */
		if (serviceForm.getCusName() != null
				&& serviceForm.getCusName().trim() != "") {
			stringBuffer.append(" and svrCustName like '%"
					+ serviceForm.getCusName() + "%'");
		}
		/*
		 * 概要
		 */
		if (serviceForm.getTitle() != null
				&& serviceForm.getTitle().trim() != "") {
			stringBuffer.append(" and svrTitle like '%"
					+ serviceForm.getTitle() + "%'");
		}
		/*
		 * 服务类型
		 */
		if (serviceForm.getServiceType() != null && serviceForm.getServiceType() .trim()!="") {
			stringBuffer.append(" and svrType='" + serviceForm.getServiceType()
					+ "'");
		}
		/*
		 * 创建时间
		 */
		if (serviceForm.getDay1() != null && serviceForm.getDay1().trim() != "") {
			stringBuffer.append(" and DATEPART(YEAR,svrCreateDate)>="
					+ serviceForm.getDay1());
		}
		if (serviceForm.getDay2() != null && serviceForm.getDay2().trim() != "") {
			stringBuffer.append(" and DATEPART(YEAR,svrCreateDate)<="
					+ serviceForm.getDay2());
		}
		/*
		 * 状态
		 */
		if (serviceForm.getStatus() != null && serviceForm.getStatus().trim() != "") {
			stringBuffer.append(" and svrStatus='" + serviceForm.getStatus()+ "'");
		}
		double result = (Double) getSession().createQuery(stringBuffer.toString())
				.uniqueResult();
		int maxPage = (int) result;
		return maxPage;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		String sql="select COUNT(*) from CstService  where svrStatus='已分配'";
		long result=(Long)getSession().createQuery(sql).uniqueResult();
		int count=(int)result;
		return count;
	}

	@Override
	public int getSize(ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0) from CstService  where svrStatus='已分配'");
		/*
		 * 客户名称
		 */
		if (serviceForm.getCusName() != null
				&& serviceForm.getCusName().trim() != "") {
			stringBuffer.append(" and svrCustName like '%"
					+ serviceForm.getCusName() + "%'");
		}
		/*
		 * 概要
		 */
		if (serviceForm.getTitle() != null
				&& serviceForm.getTitle().trim() != "") {
			stringBuffer.append(" and svrTitle like '%"
					+ serviceForm.getTitle() + "%'");
		}
		/*
		 * 服务类型
		 */
		if (serviceForm.getServiceType() != null && serviceForm.getServiceType() .trim()!="") {
			stringBuffer.append(" and svrType='" + serviceForm.getServiceType()
					+ "'");
		}
		/*
		 * 创建时间
		 */
		if (serviceForm.getDay1() != null && serviceForm.getDay1().trim() != "") {
			stringBuffer.append(" and DATEPART(YEAR,svrCreateDate)>="
					+ serviceForm.getDay1());
		}
		if (serviceForm.getDay2() != null && serviceForm.getDay2().trim() != "") {
			stringBuffer.append(" and DATEPART(YEAR,svrCreateDate)<="
					+ serviceForm.getDay2());
		}
		/*
		 * 状态
		 */
		if (serviceForm.getStatus() != null && serviceForm.getStatus().trim() != "") {
			stringBuffer.append(" and svrStatus='" + serviceForm.getStatus()+ "'");
		}
		double result = (Double) getSession().createQuery(stringBuffer.toString())
				.uniqueResult();
		int page = (int) result;
		return page;
	}

	@Override
	public CstService ByID(int id) {
		// TODO Auto-generated method stub
		CstService cstService=(CstService)getSession().load(CstService.class, id);
		return cstService;
	}

	@Override
	public int uodateCstservice(CstService cstService) {
		// TODO Auto-generated method stub
		int num=1;//修改成功
		try {
			getSession().update(cstService);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			num=0;//修改失败
		}
		return num;
	}
}
