package Notification;
import java.util.List;
import Filter.Filter;
import Listing.ListingNew;

public record NotificationRule(
	    List<Filter<ListingNew>> filters,
	    NotificationChannel channel
	) {}