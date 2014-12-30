package com.dang.order.order_intercept_release.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dang.order.order_intercept_release.api.RuleService;
import com.dang.order.order_intercept_release.dao.RuleDao;
import com.dang.order.order_intercept_release.dto.Rule;
import com.dang.rocket.core.exception.BusinessException;

@Service("ruleService")
@Path("rule")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class RuleServiceImpl implements RuleService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RuleDao ruleDao;

	@GET
	@Path("{id : \\d+}")
	public Rule getRuleById(@PathParam("id") int id) {
		try {
			return ruleDao.findByPK(Long.valueOf(id), Rule.class);
		} catch (BusinessException e) {
			logger.error("some things wrong!", e);
			return null;
		}
	}

	@POST
	public void save(Rule rule) {
		boolean isNew = null == rule.getId();
		try {
			if (isNew) {
				ruleDao.save(rule);
			} else {
				ruleDao.update(rule);
			}

		} catch (BusinessException e) {
			logger.error(isNew ? "新建" : "更新" + "规则失败", e);
		}
	}

	@GET
	public List<Rule> getAllRules() {
		return ruleDao.findAllRules();
	}

	@PostConstruct
	public boolean refreshCache() {
		RuleCacheManager.getInstance().initRules(getAllRules());
		return true;
	}

	@GET
	@Path("check/{id}")
	public void check(@PathParam("id") int id, @QueryParam("flag") boolean flag) {
		Rule rule = new Rule();
		rule.setId(id);
		rule.setCheckStatus(flag ? 1 : 2);
		try {
			ruleDao.update(rule);
		} catch (BusinessException e) {
			logger.error("some things wrong!", e);
		}
		if (flag)
			refreshCache();
	}
}
