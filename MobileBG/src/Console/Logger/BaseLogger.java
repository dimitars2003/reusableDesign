package Console.Logger;

import User.UserBase;
import User.Repository.UserRepository;

public abstract class BaseLogger {
	public abstract UserBase getUser(String username, String password,String type, UserRepository ur);
}
