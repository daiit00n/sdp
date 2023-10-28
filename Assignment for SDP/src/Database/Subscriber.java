package Database;

import decorator.IHouse;

public class Subscriber implements Observer{
    @Override
    public void handleEvent(IHouse iHouse) {
        System.out.println("======================================");
        System.out.println(iHouse.getDescription() + " has added");
        System.out.println("======================================");
    }

}
