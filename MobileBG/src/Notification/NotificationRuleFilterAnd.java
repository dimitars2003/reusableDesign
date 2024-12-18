package Notification;

import Filter.Filter;
import Filter.ComplexFilter.ComplexFilter;

public class NotificationRuleFilterAnd<T> {
	
	private ComplexFilter<Filter<T>> filters;
	private NotificationChannel channel;
	
	public NotificationRuleFilterAnd(ComplexFilter<Filter<T>> filtersAdd, NotificationChannel channelAdd){
		filters = filtersAdd;
		channel = channelAdd;
	}
	
	
}
