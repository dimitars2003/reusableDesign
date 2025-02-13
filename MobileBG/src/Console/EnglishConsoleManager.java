package Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Additional.Region;
import Console.Logger.DealerLogger;
import Console.Logger.GuestLogger;
import Console.Logger.RegisteredLogger;
import Console.MainMenu.BaseMainMenu;
import Console.MainMenu.DealerMainMenu;
import Console.MainMenu.GuestMainMenu;
import Console.MainMenu.RegisteredMainMenu;
import Console.Register.DealerRegister;
import Console.Register.RegisteredRegister;
import Filter.Filter;
import Filter.FilterTypes.ExactValueFilter;
import Filter.FilterTypes.RangeFilter;
import Listing.Listing;
import Listing.Repository.ListingRepository;
import Product.Product;
import Product.Bicycle.Bicycle;
import Product.Vehicles.RoadVehicle;
import User.UserBase;
import User.Repository.UserRepository;

public class EnglishConsoleManager extends BaseConsoleManager{
	UserBase current;
	UserRepository ur;
	
	ListingRepository lr;
	
	
	public EnglishConsoleManager(UserRepository add, ListingRepository listings) {
		ur = add;
		lr = listings;
	}
	
	private void printListing(Listing l) {
		
			
	        System.out.println("Id: " + l.getId());
	        System.out.println("Product: " + (l.getProduct() != null ? l.getProduct().toString() : "Not found"));
	        System.out.println("Region: " + (l.getRegion() != null ? l.getRegion().area() + l.getRegion().city() : "not found"));
	        System.out.println("Creator id: " + l.getOwnerId());
	        System.out.println("Expiry date: " + l.getExpiryDate());
	        System.out.println("VIP status: " + (l.getIsVip() ? "Yes" : "No"));
	        System.out.println("Describtion: " + l.getDescription());
	        System.out.println("Service: " + (l.getIsService() ? "Yes" : "No"));
	}
	
	@Override
	public void logIn() {
	    // TODO Auto-generated method stub
	    Scanner scan = new Scanner(System.in);
	    int choice = 0;
	    while (true) {
	        System.out.println("Please select what type of user you are");
	        System.out.println("1 - Log in as a registered user");
	        System.out.println("2 - Log in as a guest");
	        System.out.println("3 - Log in as a dealer");
	        System.out.println("4 - Go back");
	        choice = scan.nextInt();
	        if (choice == 3) {
	            while (true) {
	                System.out.println("Please enter a username.\n");
	                String username = scan.next();
	                System.out.println("Please enter a password.\n");
	                String pass = scan.next();
	                DealerLogger dl = new DealerLogger();
	                current = dl.getUser(username, pass, "Dealer", ur);
	                if (current == null) {
	                    System.out.println("Incorrect username or password. Please try again.\n");
	                } else {
	                    System.out.println("Successfully logged in.\n");
	                    DealerMainMenu mm = new DealerMainMenu(lr);
	                    mainMenu(mm);
	                    break;
	                }
	            }
	        } else if (choice == 1) {
	            while (true) {
	                System.out.println("Please enter a username.\n");
	                String username = scan.next();
	                System.out.println("Please enter a password.\n");
	                String pass = scan.next();
	                RegisteredLogger rl = new RegisteredLogger();
	                current = rl.getUser(username, pass, "Registered", ur);
	                if (current == null) {
	                    System.out.println("Incorrect username or password. Please try again.\n");
	                } else {
	                    System.out.println("Successfully logged in.");
	                    RegisteredMainMenu mm = new RegisteredMainMenu(lr);
	                    mainMenu(mm);
	                    break;
	                }
	            }
	        } else if (choice == 2) {
	            GuestLogger gl = new GuestLogger();
	            current = gl.getUser("", "", "Guest", ur);
	            System.out.println("Successfully logged in.");
	            GuestMainMenu mm = new GuestMainMenu(lr);
	            mainMenu(mm);
	            break;
	        } else if (choice == 4) {
	            break;
	        } else {
	            System.out.println("Invalid choice. Please try again.\n");
	        }
	    }
	    scan.close();
	}

	@Override
	public void register() {
	    // TODO Auto-generated method stub
	    Scanner scan = new Scanner(System.in);
	    int choice = 0;
	    while (true) {
	        System.out.println("Please select what type of user you are");
	        System.out.println("1 - Register as a registered user");
	        System.out.println("2 - Register as a dealer");
	        System.out.println("3 - Go back");
	        choice = scan.nextInt();
	        if (choice == 1) {
	            Vector<String> data = new Vector<String>();
	            System.out.println("Please enter a username");
	            String username = scan.next();
	            data.add(username);
	            System.out.println("Please enter an email");
	            String email = scan.next();
	            data.add(email);
	            System.out.println("Please enter a password");
	            String password = scan.next();
	            data.add(password);
	            System.out.println("Please enter a region");
	            String area = scan.next();
	            data.add(area);
	            System.out.println("Please enter a city");
	            String city = scan.next();
	            data.add(city);
	            System.out.println("Please enter a phone number");
	            String phoneNumber = scan.next();
	            data.add(phoneNumber);
	            RegisteredRegister rr = new RegisteredRegister();
	            current = rr.registerMe(ur, data);
	            if (current == null) {
	                System.out.println("A user with this information already exists. Please try again.");
	            } else {
	                System.out.println("Registration successful");
	                RegisteredMainMenu mm = new RegisteredMainMenu(lr);
	                mainMenu(mm);
	                break;
	            }
	        } else if (choice == 2) {
	            Vector<String> data = new Vector<String>();
	            System.out.println("Please enter a username");
	            String username = scan.next();
	            data.add(username);
	            System.out.println("Please enter an email");
	            String email = scan.next();
	            data.add(email);
	            System.out.println("Please enter a password");
	            String password = scan.next();
	            data.add(password);
	            System.out.println("Please enter your name");
	            String name = scan.next();
	            data.add(name);
	            System.out.println("Please enter contact information");
	            String contactInfo = scan.next();
	            data.add(contactInfo);
	            System.out.println("Please enter a region");
	            String area = scan.next();
	            data.add(area);
	            System.out.println("Please enter a city");
	            String city = scan.next();
	            data.add(city);
	            DealerRegister dr = new DealerRegister();
	            current = dr.registerMe(ur, data);
	            if (current == null) {
	                System.out.println("A user with this information already exists. Please try again.");
	            } else {
	                System.out.println("Registration successful");
	                DealerMainMenu mm = new DealerMainMenu(lr);
	                mainMenu(mm);
	                break;
	            }
	        }
	    }
	}

	

	@Override
	public void engage() {
	    Scanner scan = new Scanner(System.in);
	    int choice = 0;
	    while (true) {
	        System.out.println("Please choose what you want to do: \n");
	        System.out.println("1 - Log in to the system");
	        System.out.println("2 - Register in the system");
	        System.out.println("3 - Exit the program");

	        choice = scan.nextInt();
	        if (choice == 3) {
	            break;
	        } else if (choice == 1) {
	            logIn();
	            break;
	        } else if (choice == 2) {
	            register();
	            break;
	        } else {
	            System.out.println("Invalid choice. Please try again.\n");
	        }
	    }
	    scan.close();
	}

	@Override
	public void mainMenu(BaseMainMenu mm) {
	    System.out.println("Hello, please select one of the following options:");
	    Scanner scan = new Scanner(System.in);
	    int choice = 0;

	    System.out.println("1 - View all listings");
	    System.out.println("2 - Search for a listing");

	    if (current.getType().equals("Dealer") || current.getType().equals("Registered")) {
	        System.out.println("3 - Create a listing");
	        System.out.println("4 - View my listings");
	    }
	    if (current.getType().equals("Dealer")) {
	        System.out.println("5 - View VIP listings");
	    }
	    System.out.println("6 - Log out");

	    while (true) {
	        choice = scan.nextInt();
	        if (choice == 1) {
	            List<Listing> all = mm.checkAllListings(lr);
	            for (int i = 0; i < all.size(); i++) {
	                System.out.println("Listing " + i);
	                printListing(all.get(i));
	            }
	            break;
	        } else if (choice == 2) {
	            int search = 0;
	            System.out.println("What would you like to search by?");
	            System.out.println("1 - Price");
	            System.out.println("2 - Brand");
	            System.out.println("3 - Model");

	            while (true) {
	                search = scan.nextInt();
	                if (search == 1) {
	                    System.out.println("How would you like to search?");
	                    System.out.println("1 - Exact price");
	                    System.out.println("2 - Price range");

	                    while (true) {
	                        search = scan.nextInt();
	                        if (search == 1) {
	                            System.out.println("Enter price:");
	                            double price = scan.nextDouble();
	                            Filter<Listing> filter = new ExactValueFilter<>(l -> l.getProduct().getPrice(), price);
	                            List<Listing> found = mm.searchListing(lr, filter);
	                            for (int i = 0; i < found.size(); i++) {
	                                System.out.println("Listing " + i);
	                                printListing(found.get(i));
	                            }
	                            break;
	                        } else if (search == 2) {
	                            System.out.println("Enter maximum price:");
	                            double priceMax = scan.nextDouble();
	                            System.out.println("Enter minimum price:");
	                            double priceMin = scan.nextDouble();
	                            Filter<Listing> filter = new RangeFilter<>(l -> l.getProduct().getPrice(), priceMax, priceMin);
	                            List<Listing> found = mm.searchListing(lr, filter);
	                            for (int i = 0; i < found.size(); i++) {
	                                System.out.println("Listing " + i);
	                                printListing(found.get(i));
	                            }
	                            break;
	                        } else {
	                            System.out.println("Invalid choice. Please try again.\n");
	                        }
	                    }
	                    break;
	                } else if (search == 2) {
	                    System.out.println("Enter brand:");
	                    String brand = scan.next();
	                    ExactValueFilter<Listing, String> filter = new ExactValueFilter<>(
	                            listing -> {
	                                Product product = listing.getProduct();
	                                return (product instanceof RoadVehicle) ? ((RoadVehicle) product).getBrand() : null;
	                            },
	                            brand
	                    );
	                    List<Listing> found = mm.searchListing(lr, filter);
	                    for (int i = 0; i < found.size(); i++) {
	                        System.out.println("Listing " + i);
	                        printListing(found.get(i));
	                    }
	                    break;
	                } else if (search == 3) {
	                    System.out.println("Enter model:");
	                    String model = scan.next();
	                    ExactValueFilter<Listing, String> filter = new ExactValueFilter<>(
	                            listing -> {
	                                Product product = listing.getProduct();
	                                return (product instanceof RoadVehicle) ? ((RoadVehicle) product).getModel() : null;
	                            },
	                            model
	                    );
	                    List<Listing> found = mm.searchListing(lr, filter);
	                    for (int i = 0; i < found.size(); i++) {
	                        System.out.println("Listing " + i);
	                        printListing(found.get(i));
	                    }
	                    break;
	                } else {
	                    System.out.println("Invalid choice. Please try again.\n");
	                }
	            }
	            break;
	        } else if (choice == 3 && (current.getType().equals("Dealer") || current.getType().equals("Registered"))) {
	            System.out.println("What type of listing are you creating?");
	            System.out.println("1 - Car");
	            System.out.println("2 - Bicycle");
	            
	            while(true) {
	            	int create = scan.nextInt();
		            if (create == 1) {
		                System.out.println("Enter brand:");
		                String brand = scan.next();
		                System.out.println("Enter model:");
		                String model = scan.next();
		                System.out.println("Enter year:");
		                int year = scan.nextInt();
		                System.out.println("Enter price:");
		                double price = scan.nextDouble();
		                RoadVehicle rv = new RoadVehicle(price, brand, model, year);
		                System.out.println("Enter region:");
		                String area = scan.next();
		                System.out.println("Enter city:");
		                String city = scan.next();
		                Region r = new Region(area, city);
		                System.out.println("Enter listing expiration date:");
		                String date = scan.next();
		                System.out.println("Enter description:");
		                String desc = scan.next();
		                System.out.println("Should the listing be VIP? Enter 1 for Yes, 0 for No:");
		                boolean vipB = scan.nextInt() == 1;
		                mm.createListing(lr, rv, r, current.getId(), date, vipB, desc, false);
		                break;
		            } else if (create == 2) {
		                System.out.println("Enter brand:");
		                String brand = scan.next();
		                System.out.println("Enter price:");
		                double price = scan.nextDouble();
		                Bicycle b = new Bicycle(price, brand);
		                System.out.println("Enter region:");
		                String area = scan.next();
		                System.out.println("Enter city:");
		                String city = scan.next();
		                Region r = new Region(area, city);
		                System.out.println("Enter listing expiration date:");
		                String date = scan.next();
		                System.out.println("Enter description:");
		                String desc = scan.next();
		                System.out.println("Should the listing be VIP? Enter 1 for Yes, 0 for No:");
		                boolean vipB = scan.nextInt() == 1;
		                mm.createListing(lr, b, r, current.getId(), date, vipB, desc, false);
		                break;
		            } else {
		                System.out.println("Invalid choice. Please try again.\n");
		            }
	            }
	            break;
	        } 
	        else if (choice == 4 && (current.getType().equals("Dealer") || current.getType().equals("Registered"))) {
	            List<Listing> mine = mm.getMyListings(lr, current.getId());
	            for (int i = 0; i < mine.size(); i++) {
	                System.out.println("Listing " + i);
	                printListing(mine.get(i));
	            }
	            break;
	        } else if (choice == 5 && current.getType().equals("Dealer")) {
	            List<Listing> mine = mm.getMyListings(lr, current.getId());
	            for (int i = 0; i < mine.size(); i++) {
	                if (mine.get(i).getIsVip()) {
	                    System.out.println("VIP Listing " + i);
	                    printListing(mine.get(i));
	                }
	            }
	            break;
	        } else if (choice == 6) {
	            System.out.println("Logging out...");
	            break;
	        } else {
	            System.out.println("Invalid choice. Please try again.\n");
	        }
	    }
	}

	

}

