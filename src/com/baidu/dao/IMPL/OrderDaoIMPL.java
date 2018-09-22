package com.baidu.dao.IMPL;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.OrderDao;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.CstLost;
import com.baidu.struts.entity.OrdersLine;
import com.baidu.struts.form.ServiceForm;

public class OrderDaoIMPL extends HibernateDaoSupport implements OrderDao {

	@Override
	public List<OrdersLine> findAllOrders(String cusName,String year) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select s.odrCustomer, sum(o.oddPrice*o.oddCount) "
		+"from OrdersLine o,Orders s where o.orders.odrId=s.odrId");
		if (cusName != null && cusName.trim() != "") {
			stringBuffer.append(" and s.odrCustomer like '%"+ cusName + "%'");
		}
		if (year != null&&year.trim()!="") {
			stringBuffer.append(" and DATEPART(YEAR,s.odrDate)=" + year);
		}
		stringBuffer.append(" group by s.odrCustomer");
		stringBuffer.append(" order by sum(o.oddPrice*o.oddCount) desc");
		List<OrdersLine> list = getSession().createQuery(stringBuffer.toString()).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.struts.dao.CstcustomerDao#find(int) 默认显示
	 */
	@Override
	public List<CstCustomer> find(String type) {
		// TODO Auto-generated method stub
		String sql = "select custLevelLabel,count(custLevelLabel)"
				+ " from CstCustomer " 
				+ " where 1=1 "
				+ " group by custLevelLabel "
				+ " order by count(custLevelLabel)";
		/*
		 * 按客户等级查询
		 */
		if (type != null && type.equals("level")) {
			sql = "select custLevelLabel,count(custLevelLabel)"
					+ " from CstCustomer" 
					+ " where 1=1"
					+ " group by custLevelLabel "
					+ " order by count(custLevelLabel)";
		}
		/*
		 * 按客户满意度查询
		 */
		if (type != null && type.equals("satisfy")) {
			sql = "select custSatisfy,COUNT(custSatisfy) "
		            + "from CstCustomer"
					+ " where 1=1" 
		            + " group by custSatisfy "
					+ " order by COUNT(custSatisfy) desc";
		}
		/*
		 * 按客户信用度查询
		 */
		if (type != null && type.equals("credit")) {
			sql = "select custCredit,count(custCredit) " 
		            + " from CstCustomer"
					+ " where 1=1" 
		            + " group by custCredit "
					+ " order by count(custCredit)";
		}
		List<CstCustomer> list = getSession().createQuery(sql).list();
		return list;
	}

	public List<CstLost> findAllCstLosts(String cusName,String managerName) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("from CstLost where lstStatus='3'");
		if (cusName != null && cusName.trim() != "") {
			stringBuffer.append(" and lstCustName like '%"+ cusName + "%'");
		}
		if (managerName!= null && managerName .trim() != "") {
			stringBuffer.append(" and lstCustManagerName like '%" + managerName + "%'");
		}
		//String sql="from CstLost where lstStatus='3'";
		List<CstLost> list=getSession().createQuery(stringBuffer.toString()).list();
		return list;
	}
}
