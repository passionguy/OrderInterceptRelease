package com.dang.order.order_intercept_release.api;

import com.dang.rocket.core.exception.BusinessException;

public interface ReleaseService {

	/**
	 * 释放订单，rest调用
	 * @param orderIds 订单号，以逗号分隔
	 * @throws BusinessException
	 */
	void ReleaseByOrderIds(String orderIds) throws BusinessException;
}
