package decorator;

public class GardenDecorator extends HouseDecorator{
    public GardenDecorator(IHouse iHouse){
        super(iHouse);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with Garden";
    }
}
