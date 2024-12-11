package Product.Vehicles.RoadVehicles;

import Product.Enums.Brand;
import Product.Enums.Model;
import Product.Vehicles.RoadVehicle;

public class Truck extends RoadVehicle{
	public Truck(double price, Brand brand, Model model, int year) {
        super(price, brand, model, year);
    }
}
