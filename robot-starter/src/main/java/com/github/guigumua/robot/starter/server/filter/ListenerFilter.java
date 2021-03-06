package com.github.guigumua.robot.starter.server.filter;

import com.github.guigumua.robot.common.event.Event;
import com.github.guigumua.robot.starter.server.listener.ListenerContext;

import java.util.Comparator;

public interface ListenerFilter extends Comparator<ListenerFilter> {
	/**
	 * 拦截器接口定义
	 *
	 * @param event   事件
	 * @param context 监听器上下文
	 * @param args    将来可能进行拓展
	 * @return
	 */
	boolean apply(Event event, ListenerContext context, Object... args);

	/**
	 *
	 * @return 排序值，越大优先级越低
	 */
	default int order() {
		return Integer.MIN_VALUE;
	}

	@Override
	default int compare(ListenerFilter o1, ListenerFilter o2) {
		return o2.order() - o1.order() >= 0 ? -1 : 1;
	}
}
