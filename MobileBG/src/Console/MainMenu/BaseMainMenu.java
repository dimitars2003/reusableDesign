package Console.MainMenu;

import java.util.List;

import Additional.Region;
import Filter.Filter;
import Listing.Listing;
import Listing.Repository.ListingRepository;
import Product.Product;

public abstract class BaseMainMenu {
	ListingRepository listings;
	public BaseMainMenu(ListingRepository listings) {
		this.listings = listings;
	}
	
	public abstract List<Listing> checkAllListings(ListingRepository lr);
	public abstract List<Listing> searchListing(ListingRepository lr, Filter<Listing> filter);
	public abstract void createListing(ListingRepository lr,  
			Product product, Region region, String ownerId,
			String expiryDate, Boolean isVip, String description, Boolean isService);
	public abstract List<Listing> getMyListings(ListingRepository lr, String userId);
	public abstract void makeListingVIP(ListingRepository lr, String id);
}
