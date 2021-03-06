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

import com.baidu.biz.CstserviceBiz;
import com.baidu.struts.entity.CstService;
import com.baidu.struts.form.ServiceForm;

/** 
 * MyEclipse Struts
 * Creation date: 12-27-2016
 * 
 * XDoclet definition:
 * @struts.action parameter="flag" validate="true"
 */
public class CstserviceAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private CstserviceBiz cstserviceBiz;
	public void setCstserviceBiz(CstserviceBiz cstserviceBiz) {
		this.cstserviceBiz = cstserviceBiz;
	}


	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	/*
	 * 查询客户服务分析
	 */
	public ActionForward findAllcstService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int year=2017;
		//获取年份
	    String year1=request.getParameter("Year");
	    if (year1!=null) {
			year=Integer.parseInt(request.getParameter("Year"));
		}
		List<CstService>  listCstServices=cstserviceBiz.find(year);
		request.getSession().setAttribute("listCstServices", listCstServices);
		//System.out.println(listCstServices.size());
		return new ActionForward("/Report/ServerReport.jsp",true);
	}
	
	
	/*
	 * 查询服务归档
	 */
	public ActionForward findcstService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServiceForm serviceForm=(ServiceForm)form;
		int curPage=1;
		int pageSize=2;
		if(request.getParameter("curPage")!=null){
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}
		if(curPage<1){
			curPage=1;
		}
		//求出最大页数
		int maxPage=cstserviceBiz.getMaxPage(curPage,pageSize,serviceForm);
		if(curPage>maxPage){
			curPage=maxPage;
		}
		/*
		 * 查询记录
		 */
		int count=cstserviceBiz.getCount();
		/*
		 * 条状到多少页
		 */
		int size=-cstserviceBiz.getSize(serviceForm);
		System.out.println(serviceForm.getCusName());
		List<CstService> listServices=cstserviceBiz.findCstServices(curPage,pageSize,serviceForm);
		request.getSession().setAttribute("listServices", listServices);
		request.getSession().setAttribute("curPage", curPage);
		request.getSession().setAttribute("maxPage", maxPage);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("size", size);
		return new ActionForward("/CustomerService/ServiceDetail.jsp",true);
	}
	
	
	/*
	 * 根据编号查询服务归档
	 */
	public ActionForward findByID(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//获取编号
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("编号："+id);
		CstService cstService=cstserviceBiz.findByID(id);
		request.getSession().setAttribute("cstService", cstService);
		return new ActionForward("/CustomerService/ServiceDetailDialog.jsp",true);
	}
	
	/*
	 * 新建服务
	 */
	public ActionForward addService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//获取客户姓名
		String cusName=request.getParameter("cusName");
		//获取服务类型
		String type=request.getParameter("type");
		//获取服务概要
		String title=request.getParameter("title");
		//获取详细信息
		String svrInfo=request.getParameter("svrInfo");
		//获取创建人姓名和比编号
		String createName=(String)request.getSession().getAttribute("userName");
		int ID=(Integer)request.getSession().getAttribute("ID");
		//获取创建时间
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime=format.format(date);
		try {
			timestamp=Timestamp.valueOf(createTime);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//获取状态
		String status="新创建";
		//创建对象
		CstService cstService=new CstService();
		cstService.setSvrCustName(cusName);//客户姓名
		cstService.setSvrType(type);//服务类型
		cstService.setSvrTitle(title);//概要
		cstService.setSvrRequest(svrInfo);//详细信息
		cstService.setSvrCreateBy(createName);//创建人姓名
		cstService.setSvrCreateId(ID);//创建人编号
		cstService.setSvrCreateDate(timestamp);//当前系统时间
		cstService.setSvrStatus(status);//状态
		int num=cstserviceBiz.addCstservice(cstService);
		if (num>0) {
			//添加成功
			return new ActionForward("/CustomerService/ServiceCreate.jsp",true);
		}else {
			//天啊及失败
			return new ActionForward("/CustomerService/ServiceCreate.jsp",true);
		}
	}
}