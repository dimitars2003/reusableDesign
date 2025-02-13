package Console;

import Listing.Repository.ListingRepository;
import User.Repository.UserRepository;

public class ConsoleManager {
	ConsoleStarter cs;
	BaseConsoleManager cm;
	
	public ConsoleManager() {
		cs = new ConsoleStarter();
	}
	
	public void start(UserRepository ur, ListingRepository lr) {
		cm = cs.ChooseLanguage(ur,lr);
		cm.engage();

		return;
	}
}
