package com.dang.order.order_intercept_release.task;

import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import com.dang.order.order_intercept_release.api.ReleaseService;
import com.dang.order.order_intercept_release.dto.Rule;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;

public class TbOrderReleaseTask implements IScheduleTaskDealMulti<Rule> {
	@Resource
	private ReleaseService releaseService;
	@Override
	public List<Rule> selectTasks(String taskParameter, String ownSign, int taskItemNum,
			List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
		
		return null;
	}

	@Override
	public Comparator<Rule> getComparator() {
		return null;
	}

	@Override
	public boolean execute(Rule[] tasks, String ownSign) throws Exception {
		return true;
	}

}
