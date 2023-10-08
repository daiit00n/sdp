package decorator;

public class PoolDecorator extends HouseDecorator{
    public PoolDecorator(IHouse iHouse){
        super(iHouse);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with Pool";
    }
}
