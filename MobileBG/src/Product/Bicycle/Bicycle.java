package Product.Bicycle;

import Product.Product;


public class Bicycle extends Product{
	private String brand;
   

    public Bicycle(Double price, String brand)
    {
        super(price);
        this.setBrand(brand);
        
    }


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}
}
