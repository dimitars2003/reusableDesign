package Product.Bicycle;

import Product.Product;
import Product.Enums.Brand;

public class Bicycle extends Product{
	private Brand brand;
   

    public Bicycle(Double price, Brand brand)
    {
        super(price);
        this.setBrand(brand);
        
    }


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
