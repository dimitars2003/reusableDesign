
import Additional.Region;
import Console.ConsoleManager;
import Listing.Repository.ListingRepositoryImplementation;
import User.Repository.UserRepositoryImplementation;
import User.Roles.Dealer;



public class main {

	public static void main(String[] args) {
        // Code inside the main method
        //System.out.println("Hello, World!");
    
//	    public static void main(String[] args) {
//	        CarNew CarNew = new CarNew("Toyota", "Corolla", 2021, true);
//	        CarNew CarNew2 = new CarNew("Bmw", "e60", 2000, false);
//
//	        // всичките хиляди коли които имаме
//	        List<CarNew> CarNews = List.of(CarNew, CarNew2);
//	        
//	        List<Filter<CarNew>> filters = List.of(
//	            new ExactValueFilter<>(c -> c.getBrand(), "Toyota"),
//	            new CaseFilter<>(c -> c.getModel(), "Corolla"),
//	            new RangeFilter<>(c -> c.getYear(), 2000, 2022),
//	            new RangeFilter<>(c -> c.getBrand(), "Bmw", "Toyota")
//	        );
//
//	        // само колите от филтрите
//	        List<CarNew> matchingCarNews = filterCarNews(CarNews, filters);
//	        System.out.println("Matching CarNews:");
//	        matchingCarNews.forEach(System.out::println);
//	    }
//
//	    // не му е мястото тук, само за демонстративни цели е
//	    private static List<CarNew> filterCarNews(List<CarNew> CarNews, List<Filter<CarNew>> filters) {
//	        List<CarNew> filtered= CarNews.stream()
//		            .filter(CarNew -> filters.stream().allMatch(filter -> filter.matches(CarNew)))
//		            .toList();
//	    	return filtered;
//	    }
		
		Dealer d = new Dealer("ddd11", "dealer1", "dealer1", "dealer", "Misho", "034121312", new Region("sofiq","sofiq"));
		UserRepositoryImplementation ur = new UserRepositoryImplementation();
		ur.addToRepo(d);
		ListingRepositoryImplementation lr = new ListingRepositoryImplementation();
		
		ConsoleManager cs = new ConsoleManager();
		cs.start(ur, lr);
		
		//cs.start(,new ListingRepository());
	}
}
