package com.baidu.struts.entity;

import java.util.Date;

/**
 * CstLost entity. @author MyEclipse Persistence Tools
 */

public class CstLost implements java.io.Serializable {

	// Fields

	private Integer lstId;
	private CstCustomer cstCustomer;
	private String lstCustName;
	private Integer lstCustManagerId;
	private String lstCustManagerName;
	private Date lstLastOrderDate;
	private Date lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;

	// Constructors

	/** default constructor */
	public CstLost() {
	}

	/** minimal constructor */
	public CstLost(CstCustomer cstCustomer, String lstCustName,
			Integer lstCustManagerId, String lstCustManagerName,
			String lstStatus) {
		this.cstCustomer = cstCustomer;
		this.lstCustName = lstCustName;
		this.lstCustManagerId = lstCustManagerId;
		this.lstCustManagerName = lstCustManagerName;
		this.lstStatus = lstStatus;
	}

	/** full constructor */
	public CstLost(CstCustomer cstCustomer, String lstCustName,
			Integer lstCustManagerId, String lstCustManagerName,
			Date lstLastOrderDate, Date lstLostDate, String lstDelay,
			String lstReason, String lstStatus) {
		this.cstCustomer = cstCustomer;
		this.lstCustName = lstCustName;
		this.lstCustManagerId = lstCustManagerId;
		this.lstCustManagerName = lstCustManagerName;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lstLostDate = lstLostDate;
		this.lstDelay = lstDelay;
		this.lstReason = lstReason;
		this.lstStatus = lstStatus;
	}

	// Property accessors

	public Integer getLstId() {
		return this.lstId;
	}

	public void setLstId(Integer lstId) {
		this.lstId = lstId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getLstCustName() {
		return this.lstCustName;
	}

	public void setLstCustName(String lstCustName) {
		this.lstCustName = lstCustName;
	}

	public Integer getLstCustManagerId() {
		return this.lstCustManagerId;
	}

	public void setLstCustManagerId(Integer lstCustManagerId) {
		this.lstCustManagerId = lstCustManagerId;
	}

	public String getLstCustManagerName() {
		return this.lstCustManagerName;
	}

	public void setLstCustManagerName(String lstCustManagerName) {
		this.lstCustManagerName = lstCustManagerName;
	}

	public Date getLstLastOrderDate() {
		return this.lstLastOrderDate;
	}

	public void setLstLastOrderDate(Date lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}

	public Date getLstLostDate() {
		return this.lstLostDate;
	}

	public void setLstLostDate(Date lstLostDate) {
		this.lstLostDate = lstLostDate;
	}

	public String getLstDelay() {
		return this.lstDelay;
	}

	public void setLstDelay(String lstDelay) {
		this.lstDelay = lstDelay;
	}

	public String getLstReason() {
		return this.lstReason;
	}

	public void setLstReason(String lstReason) {
		this.lstReason = lstReason;
	}

	public String getLstStatus() {
		return this.lstStatus;
	}

	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}

}