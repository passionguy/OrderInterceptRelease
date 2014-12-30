package com.dang.order.order_intercept_release.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dang.order.OrderBase.api.OrdersService;
import com.dang.order.order_intercept_release.api.InterceptService;
import com.dang.order.order_intercept_release.dto.Rule;
import com.dang.order.order_wms_base.dto.order_queue.OrderQueue;
import com.dang.rocket.core.util.StringUtil;

@Service(value = "interceptService")
public class InterceptServiceImpl implements InterceptService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private OrdersService ordersService;

	@Override
	public boolean intercept(OrderQueue orderQueue) throws Exception {
		List<Rule> rules = RuleCacheManager.getInstance().getAllRules();
		for (Rule rule : rules) {
			StringBuilder sb = new StringBuilder("select 1 FROM orders,order_items where orders.order_id=");
			sb.append(orderQueue.getOrderId());
			sb.append(" and ");
			sb.append(rule.getRuleSql());
			if (ordersService.filterBySql(orderQueue.getOrderId(), sb.toString())) {
				logger.info(StringUtil.format("订单{0}被拦截规则{1}拦截", orderQueue.getOrderId(), rule.getId()));
				return true;
			}
		}
		return false;
	}

}
