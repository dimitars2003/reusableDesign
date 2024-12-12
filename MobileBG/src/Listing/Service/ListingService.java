package Listing.Service;

import java.util.List;

import Filter.Filter;
import Listing.Listing;

public interface ListingService {
	void addListing(Listing listing, String userId);
    void deleteById(String listingId, String userId);
    List<Listing> searchByFilter(Filter<Listing> filter);
}
