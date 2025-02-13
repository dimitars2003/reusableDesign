package User.Repository;

import java.util.HashMap;
import java.util.Map;

import User.UserBase;
import User.Roles.Guest;

public class UserRepositoryImplementation implements UserRepository
{
    private final Map<String, UserBase> storage = new HashMap<>();
    
    public boolean addToRepo(UserBase user)
    {
    	for(UserBase ub : storage.values()) {
    		if(user.getId().equals(ub.getId())) {
    			return false;
    		}
    	}
        storage.put(user.getId(), user);
		return true;
    }

    public void deleteById(String id)
    {
        storage.remove(id);
    }

    public UserBase findById(String id)
    {
        return storage.get(id);
    }

	@Override
	public UserBase findByUserName(String username,String password,String type) {
		if(type.equals("Guest")) {
			for(UserBase ub : storage.values()){
				if(ub.getType().equals(type)) {
					return ub;
				}
			}
			Guest g = new Guest ("guest1");
			storage.put("guest1", g);
			return g;
		}
		else {
			for(UserBase ub : storage.values()){
				if(ub.getType().equals(type)&&ub.isUser(username, password)) {
					return ub;
				}
			}
		}
		return null;
	}
	
    
    

}
