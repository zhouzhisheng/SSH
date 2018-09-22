package com.baidu.struts.form;

import org.apache.struts.action.ActionForm;

public class BasdictForm extends ActionForm{

	private String dictType;  //类别
	private String dictItem;  //条目
	private String dictValue; //值
	private int dictIsEditable;
	public String getDictType() {
		return dictType;
	}
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	public String getDictItem() {
		return dictItem;
	}
	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public int getDictIsEditable() {
		return dictIsEditable;
	}
	public void setDictIsEditable(int dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}
}
