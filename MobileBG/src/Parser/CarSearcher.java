package Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Listing.ListingNew;
import Product.Vehicles.RoadVehicles.CarNew;

public class CarSearcher implements Searcher{
	 private final QueryParser queryParser = new QueryParser();

	    @Override
	    public List<ListingNew> search(List<ListingNew> listings, String query) {
	        List<String> polishNotation = queryParser.toPolishNotation(query);
	        return filterListings(listings, polishNotation);
	    }

	    private List<ListingNew> filterListings(List<ListingNew> listings, List<String> polishNotation) {
	        Stack<List<ListingNew>> stack = new Stack<>();

	        for (String token : polishNotation) {
	            if (token.equals("&") || token.equals("|")) {
	                List<ListingNew> right = stack.pop();
	                List<ListingNew> left = stack.pop();
	                if (token.equals("&")) {
	                    stack.push(intersect(left, right));
	                } else {
	                    stack.push(union(left, right));
	                }
	            } else if (token.contains("=") || token.contains("<") || token.contains(">")) {
	                stack.push(applyFilter(listings, token));
	            } else {
	                throw new IllegalArgumentException("Unsupported token: " + token);
	            }
	        }

	        return stack.isEmpty() ? new ArrayList<>() : stack.pop();
	    }

	    private List<ListingNew> applyFilter(List<ListingNew> listings, String filter) {
	        String[] parts = filter.split("=", 2);
	        String attribute = parts[0].trim();
	        String value = parts[1].trim().replace("'", "");

	        List<ListingNew> result = new ArrayList<>();
	        for (ListingNew listing : listings) {
	            CarNew car = listing.getCar();
	            if ("brand".equals(attribute) && car.getBrand().equals(value)) {
	                result.add(listing);
	            } else if ("model".equals(attribute) && car.getModel().equals(value)) {
	                result.add(listing);
	            } else if ("year".equals(attribute) && Integer.toString(car.getYear()).equals(value)) {
	                result.add(listing);
	            }
	            // Add other attributes as needed
	        }
	        return result;
	    }

	    private List<ListingNew> intersect(List<ListingNew> left, List<ListingNew> right) {
	        List<ListingNew> result = new ArrayList<>(left);
	        result.retainAll(right);
	        return result;
	    }

	    private List<ListingNew> union(List<ListingNew> left, List<ListingNew> right) {
	        List<ListingNew> result = new ArrayList<>(left);
	        for (ListingNew listing : right) {
	            if (!result.contains(listing)) {
	                result.add(listing);
	            }
	        }
	        return result;
	    }

}
