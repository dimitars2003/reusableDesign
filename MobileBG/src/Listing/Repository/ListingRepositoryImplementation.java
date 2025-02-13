package Listing.Repository;

import java.util.ArrayList;
import java.util.List;

import Listing.Listing;

public class ListingRepositoryImplementation implements ListingRepository
{
    private final List<Listing> listings = new ArrayList<>();

    public void addToRepo(Listing listing)
    {
        deleteById(listing.getId());
        listings.add(listing);
    }

    public void deleteById(String id)
    {
        listings.removeIf(listing -> listing.getId().equals(id));
    }

    public Listing findById(String id)
    {
        for (Listing listing : listings)
        {
            if(listing.getId().equals(id))
            {
                return listing;
            }
        }

        return null;
    }

    public List<Listing> findAll()
    {
        return new ArrayList<>(listings);
    }

	@Override
	public List<Listing> getAllByUser(String id) {
		List<Listing> byUser = new ArrayList<Listing>();
		for(int i = 0; i < listings.size();i++) {
			if(listings.get(i).getOwnerId().equals(id)) {
				byUser.add(listings.get(i));
			}
		}
		return byUser;
	}

}
