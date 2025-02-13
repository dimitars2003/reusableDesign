package Console.MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Additional.Region;
import Filter.Filter;
import Listing.Listing;
import Listing.ListingNew;
import Listing.Repository.ListingRepository;
import Product.Product;

public class GuestMainMenu extends BaseMainMenu{
	
	public GuestMainMenu(ListingRepository listings){
		super(listings);
	}

	@Override
	public List<Listing> checkAllListings(ListingRepository lr) {
		
		
		return lr.findAll();
	}

	@Override
	public List<Listing> searchListing(ListingRepository lr, Filter<Listing> filter) {
		List<Listing> all = lr.findAll();
		
		List<Listing> filtered = all.stream().filter(Listing->filter.matches(Listing)).collect(Collectors.toList());
		
    	return filtered;		
	}

	@Override
	public void createListing(ListingRepository lr, Product product, Region region, String ownerId, String expiryDate,
			Boolean isVip, String description, Boolean isService) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Listing> getMyListings(ListingRepository lr, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeListingVIP(ListingRepository lr, String id) {
		// TODO Auto-generated method stub
		
	}

}
