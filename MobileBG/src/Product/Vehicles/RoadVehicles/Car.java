package Product.Vehicles.RoadVehicles;

import Product.Enums.Brand;
import Product.Enums.Model;
import Product.Vehicles.RoadVehicle;

public class Car extends RoadVehicle{
	 public Car(Double price, Brand brand, Model model, Integer year)
  {
      super(price, brand, model, year);
  }
}
