package rent;

import decorator.IHouse;

public class HourRent implements RentStrategy{
    @Override
    public void getType(IHouse iHouse) {
        System.out.println("You rented " + iHouse.getDescription() + " for hour.");
    }
}
