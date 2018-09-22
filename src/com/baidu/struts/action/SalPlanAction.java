/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.baidu.struts.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.dialect.SAPDBDialect;

import com.baidu.biz.SalPlanBiz;
import com.baidu.struts.entity.SalChance;
import com.baidu.struts.entity.SalPlan;
import com.baidu.struts.form.SalPlanForm;

/** 
 * MyEclipse Struts
 * Creation date: 12-28-2016
 * 
 * XDoclet definition:
 * @struts.action parameter="type" validate="true"
 */
public class SalPlanAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
     private SalPlanBiz salplanBiz;
	public SalPlanBiz getSalplanBiz() {
		return salplanBiz;
	}
	public void setSalplanBiz(SalPlanBiz salplanBiz) {
		this.salplanBiz = salplanBiz;
	}
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SalPlanForm salPlanForm=(SalPlanForm)form;
		int pageSize=2;
		int curpage=1;
		if(request.getParameter("curpage")!=null){
			curpage=Integer.parseInt(request.getParameter("curpage"));
		}
		if(curpage<1){
			curpage=1;
		}
		int maxpage=salplanBiz.maxPage(pageSize, salPlanForm,2);
		int  page=salplanBiz.page(salPlanForm,2);
		if(curpage>maxpage && maxpage!=0){
			curpage=maxpage;
		}
		List<SalChance>slist=salplanBiz.SalPale(pageSize, curpage, salPlanForm,2);
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("maxpage", maxpage);
		request.getSession().setAttribute("curpage", curpage);
		request.getSession().setAttribute("slist", slist);
		return new ActionForward("Sale/saleManager.jsp", true);
	}
	public ActionForward ues(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int chcId=Integer.parseInt(request.getParameter("chcId"));
		SalChance sal=salplanBiz.salPale(chcId);
	  List<SalPlan> slist=salplanBiz.list(chcId);
	  //System.out.println(slist.size()+"------");
	  request.getSession().setAttribute("slist", slist);
		request.getSession().setAttribute("sal", sal);
		return new ActionForward("Sale/SetPlay.jsp", true);
	}
	public ActionForward Ac(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	int chcId=Integer.parseInt(request.getParameter("chcId"));
	SalChance sal=salplanBiz.salPale(chcId);
	List<SalPlan>salist=salplanBiz.list(chcId);
	request.getSession().setAttribute("sal", sal);
	request.getSession().setAttribute("salist", salist);
	return new ActionForward("Sale/LookPlay.jsp", true);
	}
	public ActionForward AddSpla(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		SalPlan sp=salplanBiz.salist(Integer.parseInt(request.getParameter("plaId")));
		sp.setPlaTodo(request.getParameter("todo"));
	   int co=salplanBiz.AddSalPlan(sp);
	    if(co>0){
	    	return new ActionForward("/salPlan.do?type=ues&chcId="+id ,true);
	    }
		    return null;
	}
	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		SalPlan sal=new SalPlan();
		int id=Integer.parseInt(request.getParameter("id"));
		sal=salplanBiz.salist(Integer.parseInt(request.getParameter("plaId")));
		sal.setPlaResult(request.getParameter("todo"));
		int cc=salplanBiz.AddSalPlan(sal);
		if(cc>0){
			return new ActionForward("/salPlan.do?type=ZX&chcId="+id, true);
		}
		return null;
	}
	public ActionForward AddSalPlan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		   SalPlanForm salPlanForm=(SalPlanForm)form;
		SalPlan sal=new SalPlan();
		int id=Integer.parseInt(request.getParameter("id"));
		SalChance sall=(SalChance) request.getSession().getAttribute("sal");
		sal.setSalChance(sall);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sal.setPlaDate(sdf.parse(salPlanForm.getDatetime()));
		
		sal.setPlaTodo(salPlanForm.getTodo()); 
		int  c=salplanBiz.Add(sal);
		if(c>0){
			return new ActionForward("/salPlan.do?type=ues&chcId="+id, true);
		}
		   return null;
	}
	public ActionForward date(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		int chcId=Integer.parseInt(request.getParameter("chcId"));
        int co=salplanBiz.date(chcId);
          if(co>0){
        	  return new ActionForward("/salPlan.do?type=query", true);
          }   
		return null;
	}
	public ActionForward ZX(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		int chcId=Integer.parseInt(request.getParameter("chcId"));
		SalChance sal=salplanBiz.salPale(chcId);
	    List<SalPlan> slist=salplanBiz.list(chcId);
		request.getSession().setAttribute("sal", sal);
		request.getSession().setAttribute("slist", slist);
		return new ActionForward("Sale/ExecPlay.jsp",true);
	}
}