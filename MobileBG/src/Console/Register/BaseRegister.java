package Console.Register;

import java.util.Vector;

import User.UserBase;
import User.Repository.UserRepository;

public abstract class BaseRegister {
	public abstract UserBase registerMe(UserRepository ur, Vector<String> data);
	public abstract String generateID();
}
