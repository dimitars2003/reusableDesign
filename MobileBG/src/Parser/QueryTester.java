package Parser;

import java.util.List;
import java.util.Map;

import Listing.ListingNew;
import Product.Vehicles.RoadVehicles.CarNew;

public class QueryTester {
    public static final ListingNew BMW_X5 = new ListingNew(new CarNew("bmw", "x5", 2000, true), 10000);
    public static final ListingNew BMW_E60 = new ListingNew(new CarNew("bmw", "e60", 2005, false), 7000);
    public static final ListingNew A4_OLD = new ListingNew(new CarNew("audi", "a4", 2001, false), 5000);
    public static final ListingNew A4_NEW = new ListingNew(new CarNew("audi", "a4", 2003, false), 5000);
    public final static List<ListingNew> EXAMPLE_ListingNewS = List.of(
        BMW_X5,
        BMW_E60,
        A4_OLD,
        A4_NEW
    );
    public final static Map<String, List<ListingNew>> QUERY_TO_EXPECTED_RESULTS = Map.of(
        "brand = 'bmw'", List.of(BMW_X5, BMW_E60),
        "year < 2002", List.of(BMW_X5, A4_OLD),
        "brand = 'bmw' | model = 'a4'", List.of(BMW_X5, BMW_E60, A4_OLD, A4_NEW),
        "( brand = 'bmw' & model = 'x5' ) | ( brand = 'audi' & model = 'a4' & year > 2002 )", List.of(BMW_X5, A4_OLD)
    );
    public void test(Searcher searcher) {
        QUERY_TO_EXPECTED_RESULTS.forEach((query, expected) -> test(searcher, query, expected));
    }
    private void test(Searcher searcher, String query, List<ListingNew> expected) {
        try {
            List<ListingNew> result = searcher.search(EXAMPLE_ListingNewS, query);
            if (result.equals(expected)) {
                System.out.println("Query: " + query + " passed :)");
            } else {
                System.out.println("Query: " + query + " failed :(");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
            }
        } catch (Exception e) {
            System.out.println("Query: " + query + " failed with exception :(");
            System.out.println("Exception: " + e);
        }
    }
}
