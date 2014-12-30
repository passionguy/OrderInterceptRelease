package com.dang.order.order_intercept_release.service.impl;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements ContainerResponseFilter  {
	@Override
	public void filter(ContainerRequestContext req, ContainerResponseContext res)
			throws IOException {
		res.getHeaders().add("Access-Control-Allow-Origin", "*");
		res.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
		res.getHeaders().add("Access-Control-Max-Age", "3600");
		res.getHeaders().add("Access-Control-Allow-Headers", "x-requested-with,Content-Type,X-Auth-Token");
	}
}