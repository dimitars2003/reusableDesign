package Console.MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import Additional.Region;
import Filter.Filter;
import Listing.Listing;
import Listing.Repository.ListingRepository;
import Product.Product;

public class RegisteredMainMenu extends BaseMainMenu{
	
	
	private String generateID() {
		 return "L"+UUID.randomUUID().toString();
	}
	
	public RegisteredMainMenu(ListingRepository listings) {
		super(listings);
		// TODO Auto-generated constructor stub
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
		Listing l = new Listing(generateID(), product, region, ownerId, expiryDate, isVip, description);
		lr.addToRepo(l);
		
	}

	@Override
	public List<Listing> getMyListings(ListingRepository lr, String userId) {
		return lr.getAllByUser(userId);
	}

	@Override
	public void makeListingVIP(ListingRepository lr, String id) {
		// TODO Auto-generated method stub
		
	}

}
