package Listing;

import Product.Vehicles.RoadVehicles.CarNew;

public class ListingNew {
	private String title;
    private int price;
    private CarNew car;

    public ListingNew(String title, int price, CarNew car) {
        this.title = title;
        this.price = price;
        this.car = car;
    }

    public ListingNew(CarNew carNew, int i) {
		this.title = "";
		this.car = carNew;
		this.price = i;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarNew getCar() {
        return car;
    }

    public void setCar(CarNew car) {
        this.car = car;
    }
    
    
}
