package com.baidu.struts.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private String odrId;
	private String odrCustomer;
	private Date odrDate;
	private String odrAddr;
	private Integer odrStatus;
	private Set ordersLines = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(String odrCustomer, Date odrDate, Integer odrStatus) {
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrStatus = odrStatus;
	}

	/** full constructor */
	public Orders(String odrCustomer, Date odrDate, String odrAddr,
			Integer odrStatus, Set ordersLines) {
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
		this.ordersLines = ordersLines;
	}

	// Property accessors

	public String getOdrId() {
		return this.odrId;
	}

	public void setOdrId(String odrId) {
		this.odrId = odrId;
	}

	public String getOdrCustomer() {
		return this.odrCustomer;
	}

	public void setOdrCustomer(String odrCustomer) {
		this.odrCustomer = odrCustomer;
	}

	public Date getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Date odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrAddr() {
		return this.odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	public Integer getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(Integer odrStatus) {
		this.odrStatus = odrStatus;
	}

	public Set getOrdersLines() {
		return this.ordersLines;
	}

	public void setOrdersLines(Set ordersLines) {
		this.ordersLines = ordersLines;
	}

}