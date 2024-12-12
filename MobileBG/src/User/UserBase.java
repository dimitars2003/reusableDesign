package User;

public abstract class UserBase
{
    protected final String id;

    public UserBase(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }
}
