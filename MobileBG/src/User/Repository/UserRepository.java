package User.Repository;

import User.UserBase;

public interface UserRepository {
	boolean addToRepo(UserBase user);
    void deleteById(String id);
    UserBase findById(String id);
    UserBase findByUserName(String username,String password,String type);
}
