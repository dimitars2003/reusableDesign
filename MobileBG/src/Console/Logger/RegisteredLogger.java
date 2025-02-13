package Console.Logger;

import User.UserBase;
import User.Repository.UserRepository;
import User.Repository.UserRepositoryImplementation;
import User.Service.UserServiceImplementation;

public class RegisteredLogger extends BaseLogger{

	@Override
	public UserBase getUser(String username, String password, String type, UserRepository ur) {
		UserBase toReturn = null;
		UserServiceImplementation us = new UserServiceImplementation(ur);
		toReturn = us.isUserFound(username, password, type);
		
		return toReturn;
		
	}

}
