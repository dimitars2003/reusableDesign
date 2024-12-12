package Listing.Service;

import java.util.List;
import java.util.stream.Collectors;

import Filter.Filter;
import Listing.Listing;
import Listing.Repository.ListingRepository;
import User.UserBase;
import User.Roles.Guest;
import User.Service.UserService;

public class ListingServiceImplementation implements ListingService
{
    private final ListingRepository listingRepository;
    private final UserService userService;

    public ListingServiceImplementation(ListingRepository listingRepository, UserService userService)
    {
        this.listingRepository = listingRepository;
        this.userService = userService;
    }

    public List<Listing> searchByFilter(Filter<Listing> filter)
    {
        return listingRepository.findAll().stream().filter(filter::matches).collect(Collectors.toList());
    }

    public void addListing(Listing listing, String userId)
    {
        UserBase user = userService.getUserById(userId);

        if (user instanceof Guest)
        {
            throw new UnsupportedOperationException("ListingServiceImplementation::guest_CANNOT_add_listings");
        }

        listingRepository.addToRepo(listing);
    }

    public void deleteById(String listingId, String userId)
    {
        UserBase user = userService.getUserById(userId);

        if (user instanceof Guest)
        {
            throw new UnsupportedOperationException("ListingServiceImplementation::guest_CANNOT_delete_listings");
        }

        listingRepository.deleteById(listingId);
    }
}
