package Parser;

import java.util.List;

import Listing.ListingNew;

public interface Searcher {
    List<ListingNew> search(List<ListingNew> listings, String query);

}