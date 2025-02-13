package Console.Register;

import java.util.UUID;
import java.util.Vector;

import Additional.Region;
import User.UserBase;
import User.Repository.UserRepository;
import User.Roles.Registered;

public class RegisteredRegister extends BaseRegister{

	public String generateID() {
        return "U"+UUID.randomUUID().toString();
    }
	
	@Override
	public UserBase registerMe(UserRepository ur, Vector<String> data) {
		Region r = new Region(data.get(3),data.get(4));
		
		Registered user = new Registered(generateID(),data.get(0),data.get(1),data.get(2),r,data.get(5));
		boolean isAdded = ur.addToRepo(user);
		if(isAdded) {
			return user;
		}
		return null;
	}

}
