package Listing;

import Additional.Region;
import Product.Product;


public class Listing {

        String id;

        Product product;
        Region region;
        
        String ownerId;
        String expiryDate;

        boolean isVip;
        String description;

        boolean isService;


public Listing(String id, Product product, Region region, String ownerId, String expiryDate,
           Boolean isVip, String description)
{
	this.id = id;
	this.product = product;
	this.region = region;
	this.ownerId = ownerId;
	this.expiryDate = expiryDate;
	this.isVip = isVip;
	this.description = description;
	this.isService = false;
}

public Listing(String id, Region region, String ownerId, String expiryDate, Boolean isVip,
           String description)
{
	this.id = id;
	this.product = null;
	this.region = region;
	this.ownerId = ownerId;
	this.expiryDate = expiryDate;
	this.isVip = isVip;
	this.description = description;
	this.isService = true;
	
}

public String getId()
{
return this.id;
}

public Region getRegion()
{
return this.region;
}

public Product getProduct()
{
return this.product;
}

public String getOwnerId()
{
return this.ownerId;
}

public String getExpiryDate()
{
return this.expiryDate;
}

public Boolean getIsVip()
{
return this.isVip;
}

public String getDescription()
{
return this.description;
}

public Boolean getIsService() {
return this.isService;
}
public void setVip(boolean add) {
	isVip = add;
}
}
