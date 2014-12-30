package com.dang.order.order_intercept_release.api;

import org.springframework.stereotype.Service;

import com.dang.order.order_wms_base.dto.order_queue.OrderQueue;

@Service
public interface InterceptService {
	
	/**
	 * 拦截队列<br/>
	 * 如果拦截成功，写入订单拦截队列表，更新状态，并告诉订单控制中心此订单被拦截
	 * 如果没有被拦截，更新状态，并告诉订单控制中心此订单未被拦截
	 * @param orderId
	 * @return
	 */
	boolean intercept(OrderQueue orderQueue) throws Exception;
	
}
