package User.Service;

import User.UserBase;
import User.Repository.UserRepository;

public class UserServiceImplementation implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void addUser(UserBase user)
    {
        if (userRepository.findById(user.getId()) != null)
        {
            return;
        }
        userRepository.addToRepo(user);
    }

    public void deleteUser(String id)
    {
        if (userRepository.findById(id) == null)
        {
            return;
        }
        userRepository.deleteById(id);
    }

    public UserBase getUserById(String id)
    {
        return userRepository.findById(id);
    }

	@Override
	public UserBase isUserFound(String username, String password, String type) {
		return userRepository.findByUserName(username,password,type);
	}

}
