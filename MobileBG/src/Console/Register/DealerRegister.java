package Console.Register;

import java.util.UUID;
import java.util.Vector;

import Additional.Region;
import User.UserBase;
import User.Repository.UserRepository;
import User.Roles.Dealer;


public class DealerRegister extends BaseRegister{

	@Override
	public UserBase registerMe(UserRepository ur, Vector<String> data) {
		Region r = new Region(data.get(5),data.get(6));
		
		Dealer user = new Dealer(generateID(),data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),r);
		boolean isAdded = ur.addToRepo(user);
		if(isAdded) {
			return user;
		}
		return null;
	}

	@Override
	public String generateID() {
		 return "D"+UUID.randomUUID().toString();
	}
	
}
