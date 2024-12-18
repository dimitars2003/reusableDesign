package Notification;

import java.util.ArrayList;
import java.util.List;

import Filter.Filter;
import Listing.ListingNew;

public class NotificationService {
    private final List<NotificationRule> notificationRules = new ArrayList<>();

    public void subscribe(NotificationRule notificationRule) {
        notificationRules.add(notificationRule);
    }

    public void onNewListingAdded(ListingNew listing) {
        for (NotificationRule notificationRule : notificationRules) {
            boolean shouldNotify = true;
            for (Filter<ListingNew> filter : notificationRule.filters()) {
                if (!filter.matches(listing)) {
                    shouldNotify = false;
                    break;
                }
            }
            if (shouldNotify) {
                String message = listing.getCar().getBrand() + " "
                    + listing.getCar().getModel() +
                    " for " + listing.getPrice();
                notificationRule.channel().notify(
                    "New car found for you!",
                    message
                );
            }
        }
    }
}