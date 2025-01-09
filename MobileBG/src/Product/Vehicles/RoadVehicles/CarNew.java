package Product.Vehicles.RoadVehicles;

public class CarNew {
	private String brand;
	private String model;
	private int year;
	private boolean isManual;
	
	public CarNew(String brandAdd, String modelAdd, int priceAdd, boolean isManualAdd) {
		brand = brandAdd;
		model = modelAdd;
		year = priceAdd;
		isManual = isManualAdd;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return year;
	}

	public void setPrice(int price) {
		this.year = price;
	}

	public boolean isManual() {
		return isManual;
	}

	public void setManual(boolean isManual) {
		this.isManual = isManual;
	}

	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}

}
