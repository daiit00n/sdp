package Adapter;

import decorator.IHouse;

public class Tenge{
    float price;
    IHouse iHouse;
    public Tenge(IHouse iHouse) {
        this.iHouse = iHouse;
    }

    public float getPrice() {
        price += iHouse.getPrice();
        return price;
    }

    public void priceDisplay() {
        System.out.println("Price: " + getPrice() + "T");
    }
}
