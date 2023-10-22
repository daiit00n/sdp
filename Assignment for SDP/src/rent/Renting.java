package rent;

import decorator.House;
import decorator.IHouse;

public class Renting {
    RentStrategy rentStrategy;
    IHouse iHouse;

    public Renting(IHouse iHouse){
        this.iHouse = iHouse;
    }

    public void setRentStrategy(RentStrategy rentStrategy) {
        this.rentStrategy = rentStrategy;
    }

    public void renting(){
        rentStrategy.getType(iHouse);
    }
}
