package com.dang.order.order_intercept_release.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dang.order.order_intercept_release.api.ReleaseService;
import com.dang.rocket.core.exception.BusinessException;

@Service("releaseService")
public class ReleaseServiceImpl implements ReleaseService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void ReleaseByOrderIds(String orderIds) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
