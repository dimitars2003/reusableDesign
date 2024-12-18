package Listing.Service;

import Listing.ListingNew;
import Listing.Repository.ListingStorage;
import Notification.NotificationService;

public class ListingServiceNew {
	private final ListingStorage listingStorage;
    private final NotificationService notificationService;

    public ListingServiceNew(ListingStorage listingStorage, NotificationService notificationService) {
        this.listingStorage = listingStorage;
        this.notificationService = notificationService;
    }

    public void addListing(ListingNew listing) {
        listingStorage.addListing(listing);
        notificationService.onNewListingAdded(listing);
    }
}
