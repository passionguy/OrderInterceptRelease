package com.dang.order.order_intercept_release.api;

import java.util.List;

import com.dang.order.order_intercept_release.dto.Rule;

public interface RuleService {
	Rule getRuleById(int id);

	void save(Rule rule);

	List<Rule> getAllRules();

	void check(int id, boolean flag);
}
