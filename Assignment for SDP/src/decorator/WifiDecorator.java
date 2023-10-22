package decorator;

public class WifiDecorator extends HouseDecorator{
    public WifiDecorator(IHouse iHouse){
        super(iHouse);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with Wi-Fi";
    }

    @Override
    public float getPrice() {
        return super.getPrice() + 11.99F;
    }
}
