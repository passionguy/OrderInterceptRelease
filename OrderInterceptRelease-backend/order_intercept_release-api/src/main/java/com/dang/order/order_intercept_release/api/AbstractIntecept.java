package com.dang.order.order_intercept_release.api;

public abstract class AbstractIntecept implements InterceptService{
	abstract boolean isNeedIntecept();

	abstract void fireIntecept();

	abstract void fireNotIntecept();

	void intercept() {
		if (isNeedIntecept()) {
			fireIntecept();
			return;
		}
		fireNotIntecept();
	}
}
