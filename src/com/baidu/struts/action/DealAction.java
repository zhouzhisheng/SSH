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

import com.baidu.biz.DealBiz;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

/**
 * MyEclipse Struts Creation date: 01-03-2017
 * 
 * XDoclet definition:
 * 
 * @struts.action parameter="flag" scope="request"
 */
public class DealAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	private DealBiz dealBiz;

	public void setDealBiz(DealBiz dealBiz) {
		this.dealBiz = dealBiz;
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
	public ActionForward find(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ServiceForm serviceForm = (ServiceForm) form;
		//System.out.println(serviceForm.getCusName());
		int curPage = 1;
		int pageSize = 2;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		if (curPage < 1) {
			curPage = 1;
		}
		// 求出最大页数
		int maxPage = dealBiz.getMaxPage(curPage, pageSize, serviceForm);
		if (curPage > maxPage) {
			curPage = maxPage;
		}
		/*
		 * 查询记录
		 */
		int count = dealBiz.getCount();
		/*
		 * 跳转到多少也
		 */
		int size = dealBiz.getSize(serviceForm);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("size", size);
		List<CstService> listCstServices=null;
		if(maxPage!=0){
		 listCstServices = dealBiz.findCstServices(curPage,
				pageSize, serviceForm);
		}
		
		request.getSession().setAttribute("curPage", curPage);
		request.getSession().setAttribute("maxPage", maxPage);
		request.getSession().setAttribute("listCstServices", listCstServices);
		return new ActionForward("/CustomerService/ServiceDispose.jsp", true);
	}

	/*
	 * 根据编号查询服务分配详情
	 */
	public ActionForward getByID(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获取编号
		int id = Integer.parseInt(request.getParameter("id"));
		CstService cstService = dealBiz.ByID(id);
		request.getSession().setAttribute("cstService", cstService);
		return new ActionForward("/CustomerService/ServiceDisposeDialog.jsp",
				true);
	}

	/*
	 * 添加服务处理结果
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获取对象
		CstService cstService = (CstService) request.getSession().getAttribute(
				"cstService");
		//获取系统的处理时间
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
		//获取处理人姓名和编号
		String createName=(String)request.getSession().getAttribute("userName");
		int ID=(Integer)request.getSession().getAttribute("ID");
		// 获取服务处理
		String svrDeal = request.getParameter("result");
		// 创建实体对象
		CstService cstService2 = new CstService();
		
		// 客户名称
		cstService2.setSvrCustName(cstService.getSvrCustName());
		//客户编号
		cstService2.setCstCustomer(cstService.getCstCustomer());
		// 服务类型
		cstService2.setSvrType(cstService.getSvrType());
		// 服务概要
		cstService2.setSvrTitle(cstService.getSvrTitle());
		// 服务请求
		cstService2.setSvrRequest(cstService.getSvrRequest());
		
		// 创建人编号
		cstService2.setSvrCreateId(cstService.getSvrCreateId());
		// 创建人姓名
		cstService2.setSvrCreateBy(cstService.getSvrCreateBy());
		//创建时间
		cstService2.setSvrCreateDate(cstService.getSvrCreateDate());
		
		// 分配人编号
		cstService2.setSvrDueId(cstService.getSvrDueId());
		// 分配人姓名
		cstService2.setSvrDueTo(cstService.getSvrDueTo());
		// 分配时间
		cstService2.setSvrDueDate(cstService.getSvrDueDate());
		
		//处理人编号
		cstService2.setSvrDealId(ID);
		//处理人姓名
		cstService2.setSvrDealBy(createName);
		//处理时间
		cstService2.setSvrDealDate(timestamp);
		
		//服务处理
		cstService2.setSvrDeal(svrDeal);
		//状态
		cstService2.setSvrStatus(cstService.getSvrStatus());
		cstService2.setSvrId(cstService.getSvrId());
		int num=dealBiz.updateCstservice(cstService2);
		ActionForward forward=null;
		if (num>0) {
			//获取服务处理对象
			CstService cstService3=dealBiz.ByID(cstService2.getSvrId());
			//修改服务状态
			cstService3.setSvrStatus("已处理");
			int num1=dealBiz.updateCstservice(cstService3);
			if (num1>0) {
				//修改成功
				return new ActionForward("/deal.do?flag=find", true);
			}	
		}else {
			//修改失败
			forward=new ActionForward("/CustomerService/ServiceDisposeDialog.jsp",true);
		}
		return forward;
	}
}