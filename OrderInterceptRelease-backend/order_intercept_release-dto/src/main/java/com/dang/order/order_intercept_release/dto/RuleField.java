package com.dang.order.order_intercept_release.dto;

import com.dang.rocket.core.model.BaseModel;

/**
 * 
 * @description:	 TODO add description
 * @table rule_field 
 * @version  Ver 1.0
 * @author   code generate
 * @Date	 2014
 *
 */
public class RuleField extends BaseModel{
 
	private static final long serialVersionUID = -2777430539639097349L;

	/**
     * 描述:id <br>    
     * 字段: id  INT(10)  
     */	
	private java.lang.Integer id;
 
	 /**
     * 描述:表名 <br>    
     * 字段: field_table  TEXT(65535)  
     */	
	private java.lang.String fieldTable;
 
	 /**
     * 描述:字段名 <br>    
     * 字段: field_name  TEXT(65535)  
     */	
	private java.lang.String fieldName;
 
	 /**
     * 描述:字段描述 <br>    
     * 字段: field_desc  TEXT(65535)  
     */	
	private java.lang.String fieldDesc;
 
	 /**
     * 描述:字段类型 <br>    
     * 字段: field_type  TEXT(65535)  
     */	
	private java.lang.String fieldType;
 
	 /**
     * 描述:枚举值 <br>    
     * 字段: enum_values  TEXT(65535)  
     */	
	private java.lang.String enumValues;
 

	public RuleField(){
	}

	public RuleField(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	
    
    
	public void setFieldTable(java.lang.String fieldTable) {
		this.fieldTable = fieldTable;
	}
	
	public java.lang.String getFieldTable() {
		return this.fieldTable;
	}
	
    
    
	public void setFieldName(java.lang.String fieldName) {
		this.fieldName = fieldName;
	}
	
	public java.lang.String getFieldName() {
		return this.fieldName;
	}
	
    
    
	public void setFieldDesc(java.lang.String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}
	
	public java.lang.String getFieldDesc() {
		return this.fieldDesc;
	}
	
    
    
	public void setFieldType(java.lang.String fieldType) {
		this.fieldType = fieldType;
	}
	
	public java.lang.String getFieldType() {
		return this.fieldType;
	}
	
    
    
	public void setEnumValues(java.lang.String enumValues) {
		this.enumValues = enumValues;
	}
	
	public java.lang.String getEnumValues() {
		return this.enumValues;
	}
	
    
    
 
}

