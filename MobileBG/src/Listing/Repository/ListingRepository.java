package Listing.Repository;

import java.util.List;

import Listing.Listing;

public interface ListingRepository
{
    void addToRepo(Listing listing);
    void deleteById(String id);
    Listing findById(String id);
    List<Listing> findAll();
}