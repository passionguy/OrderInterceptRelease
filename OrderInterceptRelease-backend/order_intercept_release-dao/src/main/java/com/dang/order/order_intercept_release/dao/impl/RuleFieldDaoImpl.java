package com.dang.order.order_intercept_release.dao.impl;

import java.util.List;

import com.dang.order.order_intercept_release.dao.RuleFieldDao;
import com.dang.order.order_intercept_release.dto.Rule;
import com.dang.order.order_intercept_release.dto.RuleField;
import com.dang.rocket.core.annotation.Dao;
import com.dang.rocket.dao.mybatis.impl.MyBatisBaseDaoImpl;

/**
 * 
 * @description:	 TODO add description
 * @version  Ver 1.0
 * @author   code generate
 * @Date	 2014
 *
 */
@Dao
public class RuleFieldDaoImpl extends MyBatisBaseDaoImpl<RuleField,java.lang.Integer> implements  RuleFieldDao{

	@Override
	public List<RuleField> findAll() {
		return getCurSqlSessionTemplate().selectList("com.dang.order.order_intercept_release.dto.RuleField.findAll");
	}
}
