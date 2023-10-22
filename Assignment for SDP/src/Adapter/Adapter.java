package Adapter;

import decorator.IHouse;

public class Adapter extends Tenge{

    public Adapter(IHouse iHouse){
        super(iHouse);
    }

    @Override
    public float getPrice() {
        return super.getPrice() * 5;
    }

    @Override
    public void priceDisplay() {
        super.priceDisplay();
    }
}


