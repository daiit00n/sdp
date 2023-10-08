package rent;

import decorator.IHouse;

public interface RentStrategy {
    void getType(IHouse iHouse);
}
