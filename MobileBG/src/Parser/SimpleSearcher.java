package Parser;

import java.util.ArrayList;
import java.util.List;

import Listing.ListingNew;

public class SimpleSearcher implements Searcher{

	@Override
	public List<ListingNew> search(List<ListingNew> listings, String query) {
		List<ListingNew> wanted = new ArrayList<ListingNew>();
		System.out.println(query);
		return wanted;
	}

}
