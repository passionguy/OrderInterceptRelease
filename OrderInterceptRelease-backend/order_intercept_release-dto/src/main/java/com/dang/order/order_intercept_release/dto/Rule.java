package com.dang.order.order_intercept_release.dto;

import com.dang.rocket.core.model.BaseModel;

/**
 * 
 * @description:	 TODO add description
 * @table rule 
 * @version  Ver 1.0
 * @author   code generate
 * @Date	 2014
 *
 */
public class Rule extends BaseModel{
 
	private static final long serialVersionUID = 4015321919880609635L;

	/**
     * 描述:id <br>    
     * 字段: id  INT(10)  
     */	
	private java.lang.Integer id;
 
	 /**
     * 描述:规则名称 <br>    
     * 字段: rule_name  TEXT(65535)  
     */	
	private java.lang.String ruleName;
 
	 /**
     * 描述:规则配置json串 <br>    
     * 字段: rule_json  TEXT(65535)  
     */	
	private java.lang.String ruleJson;
 
	 /**
     * 描述:sql <br>    
     * 字段: rule_sql  TEXT(65535)  
     */	
	private java.lang.String ruleSql;
 
	 /**
     * 描述:规则类型(1:拦截规则,2:释放规则) <br>    
     * 字段: rule_type  TINYINT(3)  
     */	
	private Integer ruleType;
 
	 /**
     * 描述:拦截生效时间 <br>    
     * 字段: effect_time_start  DATETIME(19)  
     */	
	private java.util.Date effectTimeStart;
	//【非数据库字段，查询时使用】
	private java.util.Date effectTimeStartBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date effectTimeStartEnd;
 
	 /**
     * 描述:拦截结束时间 <br>    
     * 字段: effect_time_end  DATETIME(19)  
     */	
	private java.util.Date effectTimeEnd;
	//【非数据库字段，查询时使用】
	private java.util.Date effectTimeEndBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date effectTimeEndEnd;
 
	 /**
     * 描述:创建时间 <br>    
     * 字段: creation_date  DATETIME(19)  
     */	
	private java.util.Date creationDate;
	//【非数据库字段，查询时使用】
	private java.util.Date creationDateBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date creationDateEnd;
 
	 /**
     * 描述:最近修改时间 <br>    
     * 字段: last_modify_date  DATETIME(19)  
     */	
	private java.util.Date lastModifyDate;
	//【非数据库字段，查询时使用】
	private java.util.Date lastModifyDateBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date lastModifyDateEnd;
 
	 /**
     * 描述:创建人 <br>    
     * 字段: creator  INT(10)  
     */	
	private java.lang.Integer creator;
 
	 /**
     * 描述:最近修改人 <br>    
     * 字段: last_modifier  INT(10)  
     */	
	private java.lang.Integer lastModifier;
 
	 /**
     * 描述:审核状态 <br>    
     * 字段: check_status  TINYINT(3)  
     */	
	private Integer checkStatus;
 

	public Rule(){
	}

	public Rule(
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
	
    
    
	public void setRuleName(java.lang.String ruleName) {
		this.ruleName = ruleName;
	}
	
	public java.lang.String getRuleName() {
		return this.ruleName;
	}
	
    
    
	public void setRuleJson(java.lang.String ruleJson) {
		this.ruleJson = ruleJson;
	}
	
	public java.lang.String getRuleJson() {
		return this.ruleJson;
	}
	
    
    
	public void setRuleSql(java.lang.String ruleSql) {
		this.ruleSql = ruleSql;
	}
	
	public java.lang.String getRuleSql() {
		return this.ruleSql;
	}
	
    
    
	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}
	
	public Integer getRuleType() {
		return this.ruleType;
	}
	
    
    
	public void setEffectTimeStart(java.util.Date effectTimeStart) {
		this.effectTimeStart = effectTimeStart;
	}
	
	public java.util.Date getEffectTimeStart() {
		return this.effectTimeStart;
	}
	
    public void setEffectTimeStartBegin(java.util.Date effectTimeStartBegin) {
		this.effectTimeStartBegin = effectTimeStartBegin;
	}
	
	public java.util.Date getEffectTimeStartBegin() {
		return this.effectTimeStartBegin;
	}
	
	public void setEffectTimeStartEnd(java.util.Date effectTimeStartEnd) {
		this.effectTimeStartEnd = effectTimeStartEnd;
	}
	
	public java.util.Date getEffectTimeStartEnd() {
		return this.effectTimeStartEnd;
	}	
    
    
	public void setEffectTimeEnd(java.util.Date effectTimeEnd) {
		this.effectTimeEnd = effectTimeEnd;
	}
	
	public java.util.Date getEffectTimeEnd() {
		return this.effectTimeEnd;
	}
	
    public void setEffectTimeEndBegin(java.util.Date effectTimeEndBegin) {
		this.effectTimeEndBegin = effectTimeEndBegin;
	}
	
	public java.util.Date getEffectTimeEndBegin() {
		return this.effectTimeEndBegin;
	}
	
	public void setEffectTimeEndEnd(java.util.Date effectTimeEndEnd) {
		this.effectTimeEndEnd = effectTimeEndEnd;
	}
	
	public java.util.Date getEffectTimeEndEnd() {
		return this.effectTimeEndEnd;
	}	
    
    
	@SuppressWarnings("unused")
	private void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public java.util.Date getCreationDate() {
		return this.creationDate;
	}
	
    public void setCreationDateBegin(java.util.Date creationDateBegin) {
		this.creationDateBegin = creationDateBegin;
	}
	
	public java.util.Date getCreationDateBegin() {
		return this.creationDateBegin;
	}
	
	public void setCreationDateEnd(java.util.Date creationDateEnd) {
		this.creationDateEnd = creationDateEnd;
	}
	
	public java.util.Date getCreationDateEnd() {
		return this.creationDateEnd;
	}	
    
	@SuppressWarnings("unused")
	private void setLastModifyDate(java.util.Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	
	public java.util.Date getLastModifyDate() {
		return this.lastModifyDate;
	}
	
    public void setLastModifyDateBegin(java.util.Date lastModifyDateBegin) {
		this.lastModifyDateBegin = lastModifyDateBegin;
	}
	
	public java.util.Date getLastModifyDateBegin() {
		return this.lastModifyDateBegin;
	}
	
	public void setLastModifyDateEnd(java.util.Date lastModifyDateEnd) {
		this.lastModifyDateEnd = lastModifyDateEnd;
	}
	
	public java.util.Date getLastModifyDateEnd() {
		return this.lastModifyDateEnd;
	}	
    
    
	public void setCreator(java.lang.Integer creator) {
		this.creator = creator;
	}
	
	public java.lang.Integer getCreator() {
		return this.creator;
	}
	
    
    
	public void setLastModifier(java.lang.Integer lastModifier) {
		this.lastModifier = lastModifier;
	}
	
	public java.lang.Integer getLastModifier() {
		return this.lastModifier;
	}
	
    
    
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	public Integer getCheckStatus() {
		return this.checkStatus;
	}
	
    
    
 
}

