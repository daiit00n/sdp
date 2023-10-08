package rent;

import decorator.IHouse;

public class DayRent implements RentStrategy{
    @Override
    public void getType(IHouse iHouse) {
        System.out.println("You rented " + iHouse.getDescription() + " for day.");
    }
}
