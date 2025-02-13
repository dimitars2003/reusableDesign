package User.Roles;

import Additional.Region;
import User.UserBase;

public class Dealer extends UserBase
{
    private final String userName;
    private final String email;
    private final String password;

    private final String name;
    private final String contactInfo;
    private final Region region;

    public Dealer(String id, String userName, String email, String password,
                      String name, String contactInfo, Region region)
    {
        super(id);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.name = name;
        this.contactInfo = contactInfo;
        this.region = region;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getName()
    {
        return this.name;
    }

    public String getContactInfo()
    {
        return this.contactInfo;
    }

    public Region getRegion()
    {
        return this.region;
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
		return "Dealer";
	}
}
