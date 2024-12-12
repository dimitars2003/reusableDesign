package User.Repository;

import java.util.HashMap;
import java.util.Map;

import User.UserBase;

public class UserRepositoryImplementation implements UserRepository
{
    private final Map<String, UserBase> storage = new HashMap<>();
    
    public void addToRepo(UserBase user)
    {
        storage.put(user.getId(), user);
    }

    public void deleteById(String id)
    {
        storage.remove(id);
    }

    public UserBase findById(String id)
    {
        return storage.get(id);
    }

}
