package Product.Accessory;

import Product.Product;
import Product.Enums.ForVehicle;

public class Accessory extends Product{
	private ForVehicle forVehicle;
    

    public Accessory(Double price, ForVehicle forVehicle)
    {
        super(price);
        this.setForVehicle(forVehicle);
        
    }


	public ForVehicle getForVehicle() {
		return forVehicle;
	}


	public void setForVehicle(ForVehicle forVehicle) {
		this.forVehicle = forVehicle;
	}
}
