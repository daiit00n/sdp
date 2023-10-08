package rent;

import decorator.House;
import decorator.IHouse;

public class Renting {
    RentStrategy rentStrategy;
    IHouse iHouse = new House();

    public void setRentStrategy(RentStrategy rentStrategy, IHouse iHouse) {
        this.rentStrategy = rentStrategy;
        this.iHouse = iHouse;
    }

    public void renting(){
        rentStrategy.getType(iHouse);
    }
}
