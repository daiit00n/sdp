package Database;

import decorator.IHouse;

public class HouseChecker implements Observed{
    IHouse iHouse;
    Database db = new Database();

    public HouseChecker(IHouse iHouse){
        this.iHouse = iHouse;
    }

    @Override
    public boolean check(){
        return db.checkGarden();
    }
    @Override
    public void notifyHouse() {
        Observer observer = new Subscriber();
        observer.handleEvent(iHouse);
    }
}
