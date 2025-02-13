package User.Roles;

import Additional.Region;
import User.UserBase;

public class Registered extends UserBase{
	private final String userName;
    private final String email;
    private final String password;
    private final Region region;
    private final String phoneNumber;

    public Registered(String id, String userName, String email, String password, Region region, String phoneNumber)
    {
        super(id);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.region = region;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public Region getRegion()
    {
        return this.region;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

	@Override
	public boolean isUser(String username, String password) {
		if(this.userName.equals(username) && this.password.equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Registered";
	}
}
