import java.util.List;

import Filter.Filter;
import Filter.FilterTypes.CaseFilter;
import Filter.FilterTypes.ExactValueFilter;
import Filter.FilterTypes.RangeFilter;
import Product.Vehicles.RoadVehicles.CarNew;

public class main {


	    public static void main(String[] args) {
	        CarNew CarNew = new CarNew("Toyota", "Corolla", 2021, true);
	        CarNew CarNew2 = new CarNew("Bmw", "e60", 2000, false);

	        // всичките хиляди коли които имаме
	        List<CarNew> CarNews = List.of(CarNew, CarNew2);
	        
	        List<Filter<CarNew>> filters = List.of(
	            new ExactValueFilter<>(c -> c.getBrand(), "Toyota"),
	            new CaseFilter<>(c -> c.getModel(), "Corolla"),
	            new RangeFilter<>(c -> c.getYear(), 2000, 2022),
	            new RangeFilter<>(c -> c.getBrand(), "Bmw", "Toyota")
	        );

	        // само колите от филтрите
	        List<CarNew> matchingCarNews = filterCarNews(CarNews, filters);
	        System.out.println("Matching CarNews:");
	        matchingCarNews.forEach(System.out::println);
	    }

	    // не му е мястото тук, само за демонстративни цели е
	    private static List<CarNew> filterCarNews(List<CarNew> CarNews, List<Filter<CarNew>> filters) {
	        List<CarNew> filtered= CarNews.stream()
		            .filter(CarNew -> filters.stream().allMatch(filter -> filter.matches(CarNew)))
		            .toList();
	    	return filtered;
	    }
	
}
