package com.dang.order.order_intercept_release.service.impl;

import java.util.List;

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

import com.dang.order.order_intercept_release.api.RuleFieldService;
import com.dang.order.order_intercept_release.dao.RuleFieldDao;
import com.dang.order.order_intercept_release.dto.RuleField;
import com.dang.rocket.core.exception.BusinessException;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("ruleFieldService")
@Path("rulefield")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class RuleFieldServiceImpl implements RuleFieldService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RuleFieldDao ruleFieldDao;

	@POST
	public void save(RuleField ruleField) {
		boolean isNew = null == ruleField.getId();
		try {
			if (isNew) {
				ruleFieldDao.save(ruleField);
			} else {
				ruleFieldDao.update(ruleField);
			}
		} catch (BusinessException e) {
			logger.error(isNew ? "新建" : "更新" + "规则字段失败", e);
		}
	}

	@GET
	public List<RuleField> getAllRuleField() {
		return ruleFieldDao.findAll();
	}
	
//	@GET
//	public PageList<RuleField> getFields(@QueryParam("page") int page,@QueryParam("pageSize") int pageSize) {
//		try {
//			return ruleFieldDao.findByCondition(new RuleField(), new PageBounds(page, pageSize));
//		} catch (BusinessException e) {
//			logger.error("some things wrong!", e);
//			return null;
//		}
//	}

	@GET
	@Path("{id : \\d+}")
	public RuleField getRuleFieldById(@PathParam("id") int id) {
		try {
			return ruleFieldDao.findByPK(id, RuleField.class);
		} catch (BusinessException e) {
			logger.error("some things wrong!", e);
			return null;
		}
	}
}
