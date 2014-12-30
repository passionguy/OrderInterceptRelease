package com.dang.order.order_intercept_release.task;

import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import com.dang.order.order_intercept_release.service.impl.InterceptServiceImpl;
import com.dang.order.order_wms_base.api.enum_package.QueueTypeEnum;
import com.dang.order.order_wms_base.api.enum_package.SourceTypeEnum;
import com.dang.order.order_wms_base.api.enum_package.StatusEnum;
import com.dang.order.order_wms_base.api.order_queue.OrderDispatchQueueService;
import com.dang.order.order_wms_base.api.order_queue.OrderQueueService;
import com.dang.order.order_wms_base.dto.order_queue.OrderDispatchQueue;
import com.dang.order.order_wms_base.dto.order_queue.OrderQueue;
import com.dang.rocket.core.exception.BusinessException;
import com.google.common.collect.Lists;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;

public class TbOrderInterceptTask implements IScheduleTaskDealMulti<OrderQueue> {
	@Resource
	private OrderQueueService orderQueueService;
	@Resource
	private OrderDispatchQueueService orderDispatchQueueService;
	@Resource
	private InterceptServiceImpl interceptService;

	@Override
	public List<OrderQueue> selectTasks(String taskParameter, String ownSign, int taskItemNum,
			List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
		List<String> items = Lists.newArrayList();
		for (TaskItemDefine taskItemDefine : taskItemList) {
			items.add(taskItemDefine.getTaskItemId());
		}
		return orderQueueService.findBySourceTypeAndStatus(taskItemNum,items.toArray(new String[] {}), QueueTypeEnum.QT_FILTER,
				StatusEnum.WAIT);
	}

	@Override
	public Comparator<OrderQueue> getComparator() {
		return null;
	}

	@Override
	public boolean execute(OrderQueue[] tasks, String ownSign) throws Exception {
		for (OrderQueue orderQueue : tasks) {
			int sourceFlag = interceptService.intercept(orderQueue) ? 1 : 2;
			insertFilterDispatchQueue(orderQueue.getOrderId(), sourceFlag);
			updateOrderQueueStatus(orderQueue);
		}
		return true;
	}

	/**
	 * 告诉调度中心拦截过滤结果
	 * 
	 * @param orderId
	 * @param sourceFlag
	 * @throws BusinessException
	 */
	private void insertFilterDispatchQueue(Long orderId, Integer sourceFlag) throws BusinessException {
		OrderDispatchQueue orderDispatchQueue = new OrderDispatchQueue();
		orderDispatchQueue.setOrderId(orderId);
		orderDispatchQueue.setSourceType(SourceTypeEnum.STFILTER.getKey());
		orderDispatchQueue.setStatus(StatusEnum.SUCCESS.getStatus());
		orderDispatchQueue.setSourceFlag(sourceFlag);
		orderDispatchQueueService.insert(orderDispatchQueue);
	}

	/**
	 * 更新orderQueue状态
	 * 
	 * @param orderQueue
	 */
	private void updateOrderQueueStatus(OrderQueue orderQueue) {
		orderQueue.setStatus(StatusEnum.SUCCESS.getStatus());
		orderQueueService.update(orderQueue);
	}

}
