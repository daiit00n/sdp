package decorator;

public class DoghouseDecorator extends HouseDecorator{
    public DoghouseDecorator(IHouse iHouse){
        super(iHouse);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with Doghouse";
    }
}
