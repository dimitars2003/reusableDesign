package Product.Vehicles;

import Product.Product;


public class RoadVehicle extends Product{
	protected String brand;
    protected String model;
    protected Integer year;
    
    public RoadVehicle(Double price, String brand, String model,
                              Integer year)
    {
        super(price);

        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public Integer getYear()
    {
        return year;
    }


}
