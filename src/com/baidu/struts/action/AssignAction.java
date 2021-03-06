/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.baidu.struts.action;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.baidu.biz.AssignBiz;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.entity.SysUser;
import com.baidu.struts.form.ServiceForm;

/**
 * MyEclipse Struts Creation date: 12-30-2016
 * 
 * XDoclet definition:
 * 
 * @struts.action parameter="flag" scope="request"
 */
public class AssignAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	private AssignBiz assignBiz;

	public void setAssignBiz(AssignBiz assignBiz) {
		this.assignBiz = assignBiz;
	}

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ServiceForm serviceForm = (ServiceForm) form;

		int curPage = 1;
		int pageSize = 1;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		if (curPage < 1) {
			curPage = 1;
		}
		// 求出最大页数
		int maxPage = assignBiz.getMaxPage(curPage, pageSize, serviceForm);
		if (curPage > maxPage) {
			curPage = maxPage;
		}
		/*
		 * 查询记录
		 */
		int count = assignBiz.getCount();
		/*
		 * 跳转到多少也
		 */
		int size = assignBiz.getSize(serviceForm);
		/*
		 * 查询系统用户
		 */
		List<SysUser> listSysUsers = assignBiz.findAll();
		List<CstService> listCstServices = assignBiz.findCstServices(curPage,
				pageSize, serviceForm);
		request.getSession().setAttribute("listCstServices", listCstServices);
		request.getSession().setAttribute("listSysUsers", listSysUsers);
		request.getSession().setAttribute("curPage", curPage);
		request.getSession().setAttribute("maxPage", maxPage);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("size", size);
		return new ActionForward("/CustomerService/ServiceAllot.jsp", true);
	}

	/*
	 * 服务分配
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		//获取编号
		int id=Integer.parseInt(request.getParameter("id"));
		//根据编号找对象
		CstService cstService=assignBiz.getByID(id);
		//服务请求
		String Svrrequest=cstService.getSvrRequest();
		//状态
		String status=cstService.getSvrStatus();
		//获取客户名称
		String cusName=cstService.getSvrCustName();
		//获取概要
		String title=cstService.getSvrTitle();
		//获取服务类型
		String type=cstService.getSvrType();
		//获取创建人编号
		int createID=cstService.getSvrCreateId();
		//创建人姓名
		String createName=cstService.getSvrCreateBy();
		//获取创建时间
		Timestamp Createtime=cstService.getSvrCreateDate();	
		//获取分配人编号
		int cusID=Integer.parseInt(request.getParameter("cusID"));
		//根据编号找客户姓名
		SysUser sysUser=assignBiz.findByID(cusID);
		String userName=sysUser.getUsrName();
		//获取分配时间
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = format.format(date);
		try {
			timestamp = Timestamp.valueOf(createTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		CstService cstService2 = new CstService();
		//客户姓名
		cstService2.setSvrCustName(cusName);
		//概要
		cstService2.setSvrTitle(title);
		//服务类型
		cstService2.setSvrType(type);
		//状态
		cstService2.setSvrStatus(status);
		//创建人编号
		cstService2.setSvrCreateId(createID);
		//创建人姓名
		cstService2.setSvrCreateBy(createName);
		//创建时间
		cstService2.setSvrCreateDate(Createtime);
		//服务请求
		cstService2.setSvrRequest(Svrrequest);
		//分配人编号
		cstService2.setSvrDueId(cusID);
		//分配人姓名
		cstService2.setSvrDueTo(userName);
		//分配人时间
		cstService2.setSvrDueDate(timestamp);
		//编号
		cstService2.setSvrId(id);
		int num=assignBiz.updateCstservice(cstService2);
		ActionForward forward=null;
		if (num>0) {
			//修改成功
			//根据编号查询对象
			CstService cstService3=assignBiz.getByID(id);
			//修改状态
			cstService3.setSvrStatus("已分配");
			int num1=assignBiz.updateCstservice(cstService3);
			if (num1>0) {
				//成功
				return new ActionForward("/assign.do?flag=findAll",true);
			}else {
				//失败
				return new ActionForward("/CustomerService/ServiceAllot.jsp",true);
			}
		}else {
			//失败
			forward=new ActionForward("/CustomerService/ServiceAllot.jsp",true);
		}	
		return forward;
	}
	
	
	
	/*
	 * 删除服务处理
	 */
	public ActionForward DeleteCstservice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int num=assignBiz.delete(id);
		if (num>0) {
			//删除成功
			return new ActionForward("/assign.do?flag=findAll",true);
		}else {
			//删除失败
			return new ActionForward("/CustomerService/ServiceAllot.jsp",true);
		}	
	}
}