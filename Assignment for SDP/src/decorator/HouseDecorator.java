package decorator;

public abstract class HouseDecorator implements IHouse{
    IHouse iHouse;

    public HouseDecorator(IHouse iHouse){
        this.iHouse = iHouse;
    }

    @Override
    public String getDescription() {
        return iHouse.getDescription();
    }
}
