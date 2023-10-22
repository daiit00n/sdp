package decorator;

public class House implements IHouse{
    @Override
    public String getDescription() {
        return "House";
    }

    @Override
    public float getPrice() {
        return 3000F;
    }
}
