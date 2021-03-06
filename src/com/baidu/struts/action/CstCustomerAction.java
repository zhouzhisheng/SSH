/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.baidu.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.baidu.biz.ActivityBiz;
import com.baidu.biz.CsOrdersBiz;
import com.baidu.biz.CstCustomerBiz;
import com.baidu.biz.CstlinkmanBiz;
import com.baidu.struts.entity.CstActivity;
import com.baidu.struts.entity.CstCustomer;
import com.baidu.struts.entity.CstLinkman;
import com.baidu.struts.entity.Orders;
import com.baidu.struts.entity.OrdersLine;
import com.baidu.struts.entity.Product;
import com.baidu.struts.form.CstCustomerForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-04-2017
 * 
 * XDoclet definition:
 * @struts.action path="/cstCustomer" name="cstCustomerForm" parameter="type" scope="request" validate="true"
 */
public class CstCustomerAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
  private CstCustomerBiz cscustomer;
  private ActivityBiz activity;
  private CstlinkmanBiz csctlink;
  private CsOrdersBiz csOrerBiz;
  
  public void setCsOrerBiz(CsOrdersBiz csOrerBiz) {
	this.csOrerBiz = csOrerBiz;
}
public void setActivity(ActivityBiz activity) {
	this.activity = activity;
}

	public void setCsctlink(CstlinkmanBiz csctlink) {
	this.csctlink = csctlink;
}
	public void setCscustomer(CstCustomerBiz cscustomer) {
	this.cscustomer = cscustomer;
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
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
		int pageSize=3;
		int curpage=1;
		if(request.getParameter("curpage")!=null){
			curpage=Integer.parseInt(request.getParameter("curpage"));
		}
		if(curpage<1){
			curpage=1;
		}
		cstCustomerForm.setCustStatus(1);
		int maxpage=cscustomer.getMaxpage(pageSize, cstCustomerForm);
		if(curpage>maxpage && maxpage!=0){
			curpage=maxpage;
		}
		int page=cscustomer.page(cstCustomerForm);
		List<CstCustomer>list=cscustomer.querySalchance(pageSize,curpage,cstCustomerForm);
		
		request.getSession().setAttribute("curpage", curpage);
		request.getSession().setAttribute("maxpage", maxpage);
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("list", list);
		return new ActionForward("Customer/CustomerPage.jsp", true);
	}//历史订单查询
	public ActionForward Or(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
	String custNo=request.getParameter("custNo");
	if(custNo!=null){
	    CstCustomer cstCustomer=cscustomer.cs(custNo);
		request.getSession().setAttribute("cstCustomer", cstCustomer);
		request.getSession().setAttribute("custNo", custNo);
	}
		int curpage=1;
		int pageSize=2;
		if(request.getParameter("curpage")!=null){
			curpage=Integer.parseInt(request.getParameter("curpage"));
		}
		if(curpage<1){
			curpage=1;
		}
		int maxPage=csOrerBiz.MaxPage(pageSize, cstCustomerForm);
		if(curpage>maxPage && maxPage!=0){
			curpage=maxPage;
		}
	int page=csOrerBiz.page(cstCustomerForm);
	List<Orders>orlist=csOrerBiz.Orders(pageSize, curpage);
    request.getSession().setAttribute("orlist", orlist);
	request.getSession().setAttribute("maxPage", maxPage);
	request.getSession().setAttribute("curpage", curpage);
	request.getSession().setAttribute("page", page);
	return new ActionForward("Customer/OrderPage.jsp", true);
	}//交往记录查询
	public ActionForward Iv(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String custNo=request.getParameter("custNo");
		CstCustomer css=cscustomer.cs(custNo);
		List<CstActivity>list=activity.cstLinkmans(custNo);
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("css", css);
		request.getSession().setAttribute("custNo", custNo);
		return new ActionForward("Customer/ActivitysPage.jsp", true);
	}//联系人查询
	public ActionForward In(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String custNo=request.getParameter("custNo");
		CstCustomer cstCustomer=cscustomer.cs(custNo);
	   List<CstLinkman> list=csctlink.cstLinkmans(custNo);
		if(cstCustomer!=null){
			request.getSession().setAttribute("custNo", custNo);
			request.getSession().setAttribute("list", list);
			request.getSession().setAttribute("cstCustomer", cstCustomer);
		return new ActionForward("Customer/LinkManPage.jsp", true);
		}
		return null;
	}
	//交往记录添加
		public ActionForward AddCsActi(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ParseException {
			CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
			String custNo=(String)request.getSession().getAttribute("custNo");
			CstCustomer cs=(CstCustomer)request.getSession().getAttribute("css");
			CstActivity csa=new CstActivity();
			csa.setCstCustomer(cs);
			csa.setAtvCustName(cs.getCustName());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			csa.setAtvDate(sdf.parse(cstCustomerForm.getAtvDate()));
			
			csa.setAtvPlace(cstCustomerForm.getAtvPlace());
			csa.setAtvTitle(cstCustomerForm.getAtvTitle());
			csa.setAtvRemark(cstCustomerForm.getAtvRemark());
			csa.setAtvDesc(cstCustomerForm.getAtvDesc());
		int i=activity.AddCslinKman(csa);
			if(i>0){
				return new ActionForward("/cstCustomer.do?type=Iv&custNo="+custNo, true);
			}
			return null;
		}
	
	//联系人添加
	public ActionForward AddNi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
		CstCustomer cs=(CstCustomer)request.getSession().getAttribute("cstCustomer");
	String custNo=(String)request.getSession().getAttribute("custNo");
		CstLinkman cstLinkman=new CstLinkman();
		
        cstLinkman.setLkmName(cstCustomerForm.getLkmCustName());
        cstLinkman.setLkmCustName(cs.getCustName());
		cstLinkman.setCstCustomer(cs);
		cstLinkman.setLkmSex(cstCustomerForm.getLkmSex());
		cstLinkman.setLkmPostion(cstCustomerForm.getLkmPostion());
		cstLinkman.setLkmTel(cstCustomerForm.getLkmTel());
		cstLinkman.setLkmMobile(cstCustomerForm.getLkmMobile());
		cstLinkman.setLkmMemo(cstCustomerForm.getLkmMemo());
		int co=csctlink.AddCslinKman(cstLinkman);
		if(co>0){
			return new ActionForward("/cstCustomer.do?type=In&custNo="+custNo,true);
		}
		return null;
	}//联系人删除
	public ActionForward date(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String custNo=(String)request.getSession().getAttribute("custNo");
		int id=Integer.parseInt(request.getParameter("id"));
		int cw=csctlink.dateCslink(id);
     if(cw>0){
    	 return new ActionForward("/cstCustomer.do?type=In&custNo="+custNo, true);
     }		
		return null;
	}//联系人查询id
	public ActionForward inSe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int lkmId=Integer.parseInt(request.getParameter("lkmId"));
		String custNo=(String)request.getSession().getAttribute("custNo");
		CstLinkman cs=csctlink.cstLing(lkmId);
		if(cs!=null){
			request.getSession().setAttribute("cs", cs);
			return new ActionForward("/Customer/LinkManEdit.jsp", true);
		}
		return null;
	}//联系人修改
	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
		CstCustomer cs1=(CstCustomer)request.getSession().getAttribute("cstCustomer");
		CstLinkman cs=(CstLinkman)request.getSession().getAttribute("cs");
		cs.setLkmName(cstCustomerForm.getLkmCustName());
		cs.setCstCustomer(cs1);
		cs.setLkmSex(cstCustomerForm.getLkmSex());
		cs.setLkmPostion(cstCustomerForm.getLkmPostion());
		cs.setLkmTel(cstCustomerForm.getLkmTel());
		cs.setLkmMobile(cstCustomerForm.getLkmMobile());
		cs.setLkmMemo(cstCustomerForm.getLkmMemo());
	    int cw=csctlink.updateCl(cs);
		if(cw>0){
			return new ActionForward("/cstCustomer.do?type=In&custNo="+cs1.getCustNo(), true);
		}
		return null;
	}//交往记录修改
	public ActionForward UpdateCs(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
		CstCustomer cs1=(CstCustomer)request.getSession().getAttribute("css");
		CstActivity cs=(CstActivity)request.getSession().getAttribute("csa");
		cs.setAtvCustName(cstCustomerForm.getLkmCustName());
		cs.setCstCustomer(cs1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		cs.setAtvDate(sdf.parse(cstCustomerForm.getAtvDate()));
		cs.setAtvPlace(cstCustomerForm.getAtvPlace());
		cs.setAtvTitle(cstCustomerForm.getAtvTitle());
		cs.setAtvRemark(cstCustomerForm.getAtvRemark());
		cs.setAtvDesc(cstCustomerForm.getAtvDesc());
		int cw=activity.updateCl(cs);
		if(cw>0){
		return new ActionForward("/cstCustomer.do?type=Iv&custNo="+cs1.getCustNo(), true);
		}
		return null;
	}//交往记录查询ID
	public ActionForward InCe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int lkmId=Integer.parseInt(request.getParameter("atvId"));
		String custNo=(String)request.getSession().getAttribute("custNo");
		CstActivity csa=activity.cstLing(lkmId);
		request.getSession().setAttribute("csa", csa);
		return new ActionForward("Customer/ActivitysEdit.jsp", true);
	}//交往记录删除
	public ActionForward datetm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String custNo=(String)request.getSession().getAttribute("custNo");
		int id=Integer.parseInt(request.getParameter("id"));
		int cw=activity.dateCslink(id);
         if(cw>0){
    	 return new ActionForward("/cstCustomer.do?type=Iv&custNo="+custNo, true);
     }		
		return null;
	}//删除
	public ActionForward datemcc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String custNo=request.getParameter("custNo");
	    cscustomer.dateCstCustomer(custNo);
		return new ActionForward("/cstCustomer.do?type=query", true);
	}//编辑
	public ActionForward AI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;// TODO Auto-generated method stub
		String custNo=request.getParameter("custNo");
	    CstCustomer sc=cscustomer.cs(custNo);
	    BeanUtils.copyProperties(cstCustomerForm, sc);
		request.getSession().setAttribute("sc", sc);
		return new ActionForward("Customer/CustomerEdit.jsp", true);
	}
	public ActionForward Ud(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CstCustomerForm cw = (CstCustomerForm) form;// TODO Auto-generated method stub
		//System.out.println(cw.getCustLevelLabel());
		CstCustomer ss=(CstCustomer)request.getSession().getAttribute("sc");
		ss.setCustNo(ss.getCustNo());////客户编号
		ss.setCustManagerName(ss.getCustManagerName());////客户经理
		ss.setCustName(cw.getCustName());////客户名称
		ss.setCustLevelLabel(cw.getCustLevelLabel());////客户等级
		ss.setCustRegion(cw.getCustRegion());////地区
		ss.setCustSatisfy(cw.getCustSatisfy());//客户满意度
		ss.setCustCredit(cw.getCustCredit());////客户信用度
		ss.setCustAddr(cw.getCustAddr());//地址
		ss.setCustZip(cw.getCustZip());//邮编
		ss.setCustTel(cw.getCustTel());//电话
		ss.setCustFax(cw.getCustFax());//传真
		ss.setCustWebsite(cw.getCustWebsite());//网咨
		ss.setCustLicenceNo(cw.getCustLicenceNo());//营业执照号
		ss.setCustChieftain(cw.getCustChieftain());//法人
		ss.setCustBankroll(cw.getCustBankroll());//注册资金(万元)
		ss.setCustTurnover(cw.getCustTurnover());//年营业额
		ss.setCustBank(cw.getCustBank());//开户银行
		ss.setCustBankAccount(cw.getCustBankAccount());//银行账号
		ss.setCustLocalTaxNo(cw.getCustLocalTaxNo());//地税登记号;
		ss.setCustNationalTaxNo(cw.getCustNationalTaxNo());//国税登记号
		ss.setCustStatus(1);
		
		int cc=cscustomer.updateCs(ss);
		if(cc>0){
			return new ActionForward("cstCustomer.do?type=query", true);
		}
		return null;
	}
	//信息查询
	public ActionForward rO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int odrId=Integer.parseInt(request.getParameter("odrId"));
		OrdersLine Ar=csOrerBiz.orLing(odrId);
		
		List<OrdersLine>orlist=csOrerBiz.oo(Ar.getOddId());
		request.getSession().setAttribute("Ar", Ar);
		request.getSession().setAttribute("orlist", orlist);
		return new ActionForward("Customer/OrderDetail.jsp", true);
	}
	
}