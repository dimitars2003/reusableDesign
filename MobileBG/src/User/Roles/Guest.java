package User.Roles;

import User.UserBase;

public class Guest extends UserBase
{
    public Guest(String id)
    {
        super(id);
    }

	@Override
	public boolean isUser(String username, String password) {
		
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Guest";
	}
}
