package User.Service;

import User.UserBase;

public interface UserService {
	void addUser(UserBase user);
    void deleteUser(String id);
    UserBase getUserById(String id);
    UserBase isUserFound(String username, String password, String type);
}
