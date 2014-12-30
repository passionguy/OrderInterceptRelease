package com.dang.order.order_intercept_release.service.impl;

import java.util.List;

import com.dang.order.order_intercept_release.dto.Rule;
import com.google.common.collect.Lists;
/**
 * 规则缓存管理
 * @Title RuleCacheManager.java
 * @Package com.dang.order.order_intercept_release.service.impl
 * @Description 
 * @author tutu
 * @date 2014年12月15日
 *
 */
public class RuleCacheManager {
	public List<Rule> rules=Lists.newArrayList();

	private RuleCacheManager() {

	}

	private static RuleCacheManager ruleCacheManager = new RuleCacheManager();

	public static RuleCacheManager getInstance() {
		return ruleCacheManager;
	}

	public void addRule(Rule rule) {
		this.rules.add(rule);
	}

	public void initRules(List<Rule> rules) {
		this.rules.clear();
		this.rules.addAll(rules);
	}
	
	public void removeRule(Rule rule) {
		this.rules.remove(rule);
	}
	
	public List<Rule> getAllRules(){
		return this.rules;
	}
	
	public void clearAll(){
		this.rules.clear();
	}
}
