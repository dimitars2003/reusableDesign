package Console;

import Listing.Repository.ListingRepository;
import User.Repository.UserRepository;

public class LanguageFactory {
	public BaseConsoleManager getLanguage(String lang, UserRepository ur, ListingRepository lr) {
        switch (lang) {
            case "Bulgarian":
                return new BulgarianConsoleManager(ur,lr);
            case "English":
            default:
                return new EnglishConsoleManager(ur,lr);
        }
    } 
}
