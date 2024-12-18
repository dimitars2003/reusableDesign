package Listing.Repository;

import java.util.ArrayList;
import java.util.List;

import Listing.ListingNew;

public class ListingStorage {
    private final List<ListingNew> listings = new ArrayList<>();

    public void addListing(ListingNew listing) {
        listings.add(listing);
    }

    public List<ListingNew> getListings() {
        return listings;
    }
}