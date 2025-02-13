package Console;
import java.util.Scanner;

import Listing.Repository.ListingRepository;
import User.Repository.UserRepository;

public class ConsoleStarter {
	LanguageFactory factory;
	
	
	public ConsoleStarter() {
		factory = new LanguageFactory();
	}
	public BaseConsoleManager ChooseLanguage(UserRepository ur, ListingRepository lr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello, please choose a language");
		String lang = scan.next();
		BaseConsoleManager cm = factory.getLanguage(lang,ur,lr);
		scan.close();
		return cm;
		
		}
	}

