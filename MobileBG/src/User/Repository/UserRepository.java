package User.Repository;

import User.UserBase;

public interface UserRepository {
	void addToRepo(UserBase user);
    void deleteById(String id);
    UserBase findById(String id);
}
