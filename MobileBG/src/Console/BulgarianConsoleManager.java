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


public class BulgarianConsoleManager extends BaseConsoleManager{
	UserBase current;
	UserRepository ur;
	
	ListingRepository lr;
	
	
	public BulgarianConsoleManager(UserRepository add, ListingRepository listings) {
		ur = add;
		lr = listings;
	}
	
	private void printListing(Listing l) {
		
			
	        System.out.println("ИД: " + l.getId());
	        System.out.println("Продукт: " + (l.getProduct() != null ? l.getProduct().toString() : "Не е намерен"));
	        System.out.println("Регион: " + (l.getRegion() != null ? l.getRegion().area() + l.getRegion().city() : "Не е намерен"));
	        System.out.println("Ид на създател: " + l.getOwnerId());
	        System.out.println("Крайна дата: " + l.getExpiryDate());
	        System.out.println("ВИП статус: " + (l.getIsVip() ? "Да" : "Не"));
	        System.out.println("Описание: " + l.getDescription());
	        System.out.println("Обслужване: " + (l.getIsService() ? "Да" : "Не"));
	}
	
	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("Моля изберете какъв вид потребител сте");
			System.out.println("1 - Влизане като регистриран потребител");
			System.out.println("2 - Влизане като гост");
			System.out.println("3 - Влизане като продавач");
			System.out.println("4 - Върни се назад");
			choice = scan.nextInt();
			if(choice == 3) {
				while(true) {
					System.out.println("Моля въведете потребителско име. \n");
					String username = scan.next();
					System.out.println("Моля въведете парола. \n");
					String pass = scan.next();
					DealerLogger dl = new DealerLogger();
					current = dl.getUser(username, pass, "Dealer",ur);
					if(current == null) {
						System.out.println("Грешно потребителско име или парола. Опитайте пак. \n");
					}
					else {
						System.out.println("Успешно влизане в акаунт. \n");
						DealerMainMenu mm = new DealerMainMenu(lr);
						mainMenu(mm);
						break;
					}
				}
			}
			else if(choice == 1) {
				while(true) {
					System.out.println("Моля въведете потребителско име. \n");
					String username = scan.next();
					System.out.println("Моля въведете парола. \n");
					String pass = scan.next();
					RegisteredLogger rl = new RegisteredLogger();
					current = rl.getUser(username, pass, "Registered",ur);
					if(current == null) {
						System.out.println("Грешно потребителско име или парола. Опитайте пак. \n");
					}
					else {
						System.out.println("Успешно влизане в акаунт.");
						RegisteredMainMenu mm = new RegisteredMainMenu(lr);
						mainMenu(mm);
						break;
					}
				}
			}
			else if(choice == 2) {
				GuestLogger gl = new GuestLogger();
				current = gl.getUser("", "", "Guest",ur);			
				System.out.println("Успешно влизане.");
				GuestMainMenu mm = new GuestMainMenu(lr);
				mainMenu(mm);
				break;
			}
			else if(choice == 4) {
				break;
			}
			else {
				System.out.println("Невалиден избор. Моля опитайте отново \n");
			}
		}
		
		scan.close();
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("Моля изберете какъв вид потребител сте");
			System.out.println("1 - Регистриране като регистриран потребител");
			System.out.println("2 - Регистриране като продавач");
			System.out.println("3 - Върни се назад");
			choice = scan.nextInt();
			if(choice == 1) {
				Vector<String> data = new Vector<String>();
				System.out.println("Моля въведете потребителско име");
				String username = scan.next();
				data.add(username);
				System.out.println("Моля въведете имейл");
			    String email = scan.next();
			    data.add(email);
			    System.out.println("Моля въведете парола");
			    String password = scan.next();
			    data.add(password);
			    System.out.println("Моля въведете регион");
			    String area = scan.next();
			    data.add(area);
			    System.out.println("Моля въведете град");
                String city = scan.next();
                data.add(city);
                System.out.println("Моля въведете телефонен номер");
			    String phoneNumber = scan.next();
			    data.add(phoneNumber);
			    RegisteredRegister rr = new RegisteredRegister();
			    current = rr.registerMe(ur, data);
			    if(current == null) {
			    	System.out.println("Вече има такъв потребител. Моля опитайте пак");
			    }
			    else {
			    	System.out.println("Регистрация успешна");
			    	RegisteredMainMenu mm = new RegisteredMainMenu(lr);
			    	mainMenu(mm);
			    	break;
			    }
			    
			}
			else if(choice == 2) {
				Vector<String> data = new Vector<String>();
				System.out.println("Моля въведете потребителско име");
				String username = scan.next();
				data.add(username);
				System.out.println("Моля въведете имейл");
			    String email = scan.next();
			    data.add(email);
			    System.out.println("Моля въведете парола");
			    String password = scan.next();
			    data.add(password);
			    System.out.println("Моля въведете Вашето име");
			    String name = scan.next();
			    data.add(name);
			    System.out.println("Моля въведете контакти за връзка");
			    String contactInfo = scan.next();
			    data.add(contactInfo);
			    System.out.println("Моля въведете регион");
			    String area = scan.next();
			    data.add(area);
			    System.out.println("Моля въведете град");
                String city = scan.next();
                data.add(city);
                DealerRegister dr = new DealerRegister();
                current = dr.registerMe(ur, data);
			    if(current == null) {
			    	System.out.println("Вече има такъв потребител. Моля опитайте пак");
			    }
			    else {
			    	System.out.println("Регистрация успешна");
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
		while(true) {
			System.out.println("Моля изберете какво искате да направите \n");
			System.out.println("1 - Влизане в системата");
			System.out.println("2 - Регистриране в системата");
			System.out.println("3 - Излизане от програмата");
			
			
			choice = scan.nextInt();
			if(choice == 3) {
				break;
			}
			else if(choice == 1) {
				logIn();
				break;
			}
			else if(choice == 2) {
				register();
				break;
			}
			else {
				System.out.println("Невалиден избор. Моля опитайте отново \n");
			}
		}
		scan.close();
		return;
	}

	
	@Override
	public void mainMenu(BaseMainMenu mm) {
		
		System.out.println("Здравейте, изберете една от следните опции");
		Scanner scan = new Scanner(System.in);
		
		int choice = 0;
		
			System.out.println("1 - Вижте всички обяви");
			System.out.println("2 - Търсене на обява");
			if(current.getType().equals("Dealer")||current.getType().equals("Registered")) {
				System.out.println("3 - Създаване на обява");
				System.out.println("4 - Преглед на мои обяви");
			}
			if(current.getType().equals("Dealer")) {
				System.out.println("5 - Преглед на ВИП обява");
			}
			System.out.println("6 - Изход от системата");
			
			while(true) {
				choice = scan.nextInt();
				if(choice == 1) {
					List<Listing> all = new ArrayList<>();
					all = mm.checkAllListings(lr);
					for(int i = 0; i < all.size(); i++) {
						System.out.println("Обява " + i);
						printListing(all.get(i));
					}
					break;
				}
				else if(choice == 2) {
					int search = 0;
					System.out.println("По какво искате да търсите");
					System.out.println("1 - Цена");
					System.out.println("2 - Марка");
					System.out.println("3 - Модел");
					
					while(true) {
						search = scan.nextInt();
						if(search == 1) {
							System.out.println("Как искате да търсите");
							System.out.println("1 - точна цена");
							System.out.println("2 - между цени");
							while(true) {
								search = scan.nextInt();
							
								if(search == 1) {
									System.out.println("Въведете цена");
									double price = scan.nextDouble();
									Filter<Listing> filter = new ExactValueFilter<>(l->l.getProduct().getPrice(),price);
									List<Listing> found = mm.searchListing(lr,filter);
									for(int i = 0; i < found.size(); i++) {
										System.out.println("Обява " + i);
										printListing(found.get(i));
									}
									break;
								}
								else if(search == 2) {
									System.out.println("Въведете максимална цена");
									double priceMax = scan.nextDouble();
									System.out.println("Въведете минимална цена");
									double priceMin = scan.nextDouble();
									Filter<Listing> filter = new RangeFilter<>(l->l.getProduct().getPrice(),priceMax,priceMin);
									List<Listing> found = mm.searchListing(lr,filter);
									for(int i = 0; i < found.size(); i++) {
										System.out.println("Обява " + i);
										printListing(found.get(i));
									}
									break;
								}
								else {
									System.out.println("Невалиден избор. Моля опитайте отново \n");
								}
							}
							break;
						}
						else if(search == 2) {
							System.out.println("Въведете марка");
							String brand = scan.next();
							ExactValueFilter<Listing, String> filter  = new ExactValueFilter<>(
									listing -> {
							            Product product = listing.getProduct();
							            return (product instanceof RoadVehicle) ? ((RoadVehicle) product).getBrand() : null;
							        },  
						                brand
						            );
							List<Listing> found = mm.searchListing(lr,filter);
							for(int i = 0; i < found.size(); i++) {
								System.out.println("Обява " + i);
								printListing(found.get(i));
							}
							break;
						}
						else if(search == 3) {
							System.out.println("Въведете модел");
							String brand = scan.next();
							ExactValueFilter<Listing, String> filter  = new ExactValueFilter<>(
									listing -> {
							            Product product = listing.getProduct();
							            return (product instanceof RoadVehicle) ? ((RoadVehicle) product).getBrand() : null;
							        },  
						                brand
						            );
							List<Listing> found = mm.searchListing(lr,filter);
							for(int i = 0; i < found.size(); i++) {
								System.out.println("Обява " + i);
								printListing(found.get(i));
							}
							break;
						}
						else {
							System.out.println("Невалиден избор. Моля опитайте отново \n");
						}
						
					}
					break;
				}
				else if(choice == 3 && (current.getType().equals("Dealer") || current.getType().equals("Registered")) ) {
					//vavejdat se vsichki danni za obqva i se podava na mm
					System.out.println("Обява за какво правите");
					System.out.println("1 - автомобил");
					System.out.println("2 - велосипед");
					int create = scan.nextInt();
					if(create == 1) {
						
						System.out.println("Въведете марка");
						String brand = scan.next();
						
						System.out.println("Въведете модел");
						String model = scan.next();
						
						System.out.println("Въведете година");
						int year = scan.nextInt();
						
						System.out.println("Въведете цена");
						double price = scan.nextDouble();
						RoadVehicle rv = new RoadVehicle(price,brand,model,year);
						System.out.println("Въведете регион");
						String area = scan.next();
					    
					    System.out.println("Въведете град");
		                String city = scan.next();
		                Region r = new Region(area,city);
						System.out.println("Въведете крайна дата на обява");
						String date = scan.next();
						System.out.println("Въведете описание");
						String desc = scan.next();
						
						int vip = 0;
						while(true){
							vip = scan.nextInt();
							if(vip == 1 || vip == 0) {
								break;
							}
							else {
								System.out.println("Невалиден избор. Моля опитайте отново \n");
							}
						}
						boolean vipB = (vip==1? true:false);
						
						mm.createListing(lr, rv, r, current.getId(), date, vipB, desc, false);
						break;
					}
					else if(create == 2) {
						System.out.println("Въведете марка");
						String brand = scan.next();
						System.out.println("Въведете цена");
						double price = scan.nextDouble();
						Bicycle b = new Bicycle(price,brand);
						System.out.println("Въведете регион");
						String area = scan.next();
					    
					    System.out.println("Въведете град");
		                String city = scan.next();
		                Region r = new Region(area,city);
						System.out.println("Въведете крайна дата на обява");
						String date = scan.next();
						System.out.println("Въведете описание");
						String desc = scan.next();
						System.out.println("ВИП ли ще бъде обявата. За Да въведете 1. За Не въведете 0");
						int vip = 0;
						while(true){
							vip = scan.nextInt();
							if(vip == 1 || vip == 0) {
								break;
							}
							else {
								System.out.println("Невалиден избор. Моля опитайте отново \n");
							}
						}
						boolean vipB = (vip==1? true:false);
						mm.createListing(lr, b, r, current.getId(), date, vipB, desc, false);
						break;
					}
					else {
						System.out.println("Невалиден избор. Моля опитайте отново \n");
					}
					
					
				}
				else if(choice == 4 && (current.getType().equals("Dealer") || current.getType().equals("Registered"))) {
					List<Listing> mine = new ArrayList<>();
					mine = mm.getMyListings(lr, current.getId());
					for(int i = 0; i < mine.size(); i++) {
						System.out.println("Обява " + i);
						printListing(mine.get(i));
					}
					break;
				}
				else if(choice == 5 && (current.getType().equals("Dealer"))) {
					List<Listing> mine = new ArrayList<>();
					mine = mm.getMyListings(lr, current.getId());
					for(int i = 0; i < mine.size(); i++) {
						if(mine.get(i).getIsVip()) {
							System.out.println("Обява " + i);
							printListing(mine.get(i));
						}
					}
					break;
				}
				else if(choice == 6) {
					System.out.println("Излизане от системата");
					break;
				}
				else {
					System.out.println("Невалиден избор. Моля опитайте отново \n");
				}
			}
			
		}
	

}
