package com.baidu.dao.IMPL;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.CstserviceDao;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

public class CstserviceDaoIMPL extends HibernateDaoSupport implements
		CstserviceDao {

	@Override
	public int addCstservice(CstService cstService) {
		// TODO Auto-generated method stub
		int num = 1;// 添加成功
		try {
			getSession().save(cstService);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			num = 0;// 添加失败
		}
		return num;
	}

	@Override
	public List<CstService> findCstServices(int curPage, int pageSize,
			ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from CstService  where svrStatus='已归档'");
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
		if (serviceForm.getServiceType() != null
				&& serviceForm.getServiceType().trim() != "") {
			stringBuffer.append(" and svrType '%"
					+ serviceForm.getServiceType() + "%'");
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
		if (serviceForm.getStatus() != null
				&& serviceForm.getStatus().trim() != "") {
			stringBuffer.append(" and svrStatus='" + serviceForm.getStatus()
					+ "'");
		}
		List<CstService> list = getSession()
				.createQuery(stringBuffer.toString())
				.setFirstResult((curPage - 1) * pageSize)
				.setMaxResults(pageSize).list();
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql = "select COUNT(*) from CstService where svrStatus='已归档'";
		long result = (Long) getSession().createQuery(sql).uniqueResult();
		int count = (int) result;
		return count;
	}

	@Override
	public int getMaxPage(int curPage, int pageSize,ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select ceiling(COUNT(*)*1.0/" + pageSize
				+ ") from CstService where svrStatus='已归档'");
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
		double result = (Double) getSession().createQuery(
				stringBuffer.toString()).uniqueResult();
		int maxPage = (int) result;
		return maxPage;
	}

	@Override
	public CstService findByID(int ID) {
		// TODO Auto-generated method stub
		CstService cstService = (CstService) getSession().load(
				CstService.class, ID);
		return cstService;
	}

	@Override
	public int getSize(ServiceForm serviceForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
				.append("select ceiling(COUNT(*)*1.0) from CstService where svrStatus='已归档'");
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
		if (serviceForm.getServiceType() != null
				&& serviceForm.getServiceType().trim() != "") {
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
		if (serviceForm.getStatus() != null
				&& serviceForm.getStatus().trim() != "") {
			stringBuffer.append(" and svrStatus='" + serviceForm.getStatus()
					+ "'");
		}
		double result = (Double) getSession().createQuery(
				stringBuffer.toString()).uniqueResult();
		int page = (int) result;
		return page;
	}

	
	//查询客户服务分析
	@Override
	public List<CstService> find(int year) {
		// TODO Auto-generated method stub	
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select svrType,COUNT(svrType) from CstService where 1=1");
		if (year !=0) {
			stringBuffer.append(" and DATEDIFF(YYYY,svrCreateDate,'"+year+"')<=5");
		}
		stringBuffer.append(" group by svrType");
		stringBuffer.append(" order by COUNT(svrType) desc");
		List<Object[]> list=getSession().createQuery(stringBuffer.toString()).list();
		List<CstService> cList=new ArrayList<CstService>();
		for (Object[] objects : list) {
			CstService cstService=new CstService();
			String svrType=(String)objects[0];
			int count=Integer.parseInt(objects[1].toString());
			cstService.setSvrType(svrType);
			cstService.setSvrSatisfy(count);
		    cList.add(cstService);
		}
		return cList;
	}
}
