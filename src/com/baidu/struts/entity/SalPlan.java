package com.baidu.struts.entity;

import java.util.Date;

/**
 * SalPlan entity. @author MyEclipse Persistence Tools
 */

public class SalPlan implements java.io.Serializable {

	// Fields

	private Integer plaId;
	private SalChance salChance;
	private Date plaDate;
	private String plaTodo;
	private String plaResult;

	// Constructors

	/** default constructor */
	public SalPlan() {
	}

	/** minimal constructor */
	public SalPlan(SalChance salChance, Date plaDate, String plaTodo) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
	}

	/** full constructor */
	public SalPlan(SalChance salChance, Date plaDate, String plaTodo,
			String plaResult) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	// Property accessors

	public Integer getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}

	public SalChance getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public Date getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Date plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return this.plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}