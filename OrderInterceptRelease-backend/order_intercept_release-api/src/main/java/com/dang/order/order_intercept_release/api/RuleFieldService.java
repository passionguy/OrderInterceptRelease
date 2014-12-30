package com.dang.order.order_intercept_release.api;

import java.util.List;

import com.dang.order.order_intercept_release.dto.RuleField;

public interface RuleFieldService {
	RuleField getRuleFieldById(int id);

	List<RuleField> getAllRuleField();

//	List<RuleField> getFields(int page,int pageSize);
	
	void save(RuleField ruleField);
}
