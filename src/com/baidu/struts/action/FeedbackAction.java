/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.baidu.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.baidu.biz.FeedbackBiz;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

/**
 * MyEclipse Struts Creation date: 01-03-2017
 * 
 * XDoclet definition:
 * 
 * @struts.action parameter="flag" scope="request"
 */
public class FeedbackAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	private FeedbackBiz feedbackBiz;

	public void setFeedbackBiz(FeedbackBiz feedbackBiz) {
		this.feedbackBiz = feedbackBiz;
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
		ServiceForm serviceForm=(ServiceForm)form;
		int curPage=1;
		int pageSize=2;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		if (curPage < 1) {
			curPage = 1;
		}
		// 求出最大页数
		int maxPage = feedbackBiz.getMaxPage(curPage, pageSize, serviceForm);
		if (curPage > maxPage) {
			curPage = maxPage;
		}
		/*
		 * 查询有多少条记录
		 */
		int count=feedbackBiz.getCount();
		/*
		 * 跳转到多少页 
		 */
		int size=feedbackBiz.getSize(serviceForm);
		List<CstService> cstServices=null;
		if(maxPage!=0){
		cstServices= feedbackBiz.findCstServices(curPage, pageSize, serviceForm);
		}
		request.getSession().setAttribute("curPage", curPage);
		request.getSession().setAttribute("maxPage", maxPage);
		request.getSession().setAttribute("cstServices", cstServices);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("size", size);
		return new ActionForward("/CustomerService/ServiceResult.jsp", true);
	}
	/*
	 * 根据编号查询
	 */
	public ActionForward findByID(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获取编号
		int id = Integer.parseInt(request.getParameter("id"));
		CstService cstService = feedbackBiz.findByID(id);
		request.getSession().setAttribute("cstService", cstService);
		return new ActionForward("/CustomerService/ServiceResultDialog.jsp",
				true);
	}

	/*
	 * 添加服务反馈的满意度和结果
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获取对象
		CstService cstService = (CstService) request.getSession().getAttribute(
				"cstService");
		// 创建实体对象
		CstService cstService2 = new CstService();
		// 获取满意度
		int svrSatisfy = Integer.parseInt(request.getParameter("svrSatisfy"));
		// 获取处理结果
		String svrResult = request.getParameter("svrResult");
		// 客户名称
		cstService2.setSvrCustName(cstService.getSvrCustName());
		// 客户编号
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
		// 创建时间
		cstService2.setSvrCreateDate(cstService.getSvrCreateDate());

		// 分配人编号
		cstService2.setSvrDueId(cstService.getSvrDueId());
		// 分配人姓名
		cstService2.setSvrDueTo(cstService.getSvrDueTo());
		// 分配时间
		cstService2.setSvrDueDate(cstService.getSvrDueDate());

		// 处理人编号
		cstService2.setSvrDealId(cstService.getSvrDealId());
		// 处理人姓名
		cstService2.setSvrDealBy(cstService.getSvrDealBy());
		// 处理时间
		cstService2.setSvrDealDate(cstService.getSvrDealDate());

		// 服务处理
		cstService2.setSvrDeal(cstService.getSvrDeal());
		cstService2.setSvrId(cstService.getSvrId());
		// 状态
		cstService2.setSvrStatus(cstService.getSvrStatus());
		// 满意度
		cstService2.setSvrSatisfy(svrSatisfy);
		// 处理结果
		cstService2.setSvrResult(svrResult);
		int num = feedbackBiz.updateCstservice(cstService2);
		ActionForward forward = null;
		if (num > 0) {
			// 修改成功
			if (svrSatisfy >= 3) {
				// 根据编号查询对象
				CstService cstService3 = feedbackBiz.findByID(cstService2
						.getSvrId());
				// 修改服务状态
				cstService3.setSvrStatus("已归档");
				int num1 = feedbackBiz.updateCstservice(cstService3);
				if (num1 > 0) {
					// 修改成功
					return new ActionForward("/feedback.do?flag=find", true);
				}
			} else if (svrSatisfy < 3) {
				CstService cstService3 = feedbackBiz.findByID(cstService2
						.getSvrId());
				cstService3.setSvrStatus("已分配");
				int num2 = feedbackBiz.updateCstservice(cstService3);
				if (num2 > 0) {
					// 修改成功
					return new ActionForward("/feedback.do?flag=find", true);
				}
			}
		} else {
			// 修改失败
			forward = new ActionForward("/CustomerService/ServiceDisposeDialog.jsp", true);
		}
		return forward;
	}
}