package factory.product;

public class PlaPrintProfile implements IPrintProfile {

    @Override
    public void print() {
        System.out.println("Printing with PLA");
    }

    @Override
    public int getNozzleTemperature() {
        return 215;
    }

    @Override
    public int getBedTemperature() {
        return 55;
    }
}
