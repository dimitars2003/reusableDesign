package Product.Vehicles;

import Product.Product;
import Product.Enums.Brand;
import Product.Enums.Model;

public class RoadVehicle extends Product{
	protected Brand brand;
    protected Model model;
    protected Integer year;
    
    public RoadVehicle(Double price, Brand brand, Model model,
                              Integer year)
    {
        super(price);

        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public Model getModel()
    {
        return model;
    }

    public Integer getYear()
    {
        return year;
    }


}
