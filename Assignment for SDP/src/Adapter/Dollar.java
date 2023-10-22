package Adapter;

import decorator.GardenDecorator;
import decorator.House;
import decorator.IHouse;

public class Dollar implements PriceDisplay{
    float price;
    IHouse iHouse;
    public Dollar(IHouse iHouse) {
        this.iHouse = iHouse;
    }

    @Override
    public float getPrice() {
        price += iHouse.getPrice();
        return price;
    }

    @Override
    public void priceDisplay() {
        System.out.println("Price: " + getPrice() + "$");
    }
}
