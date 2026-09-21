package factory.product;

public class AbsPrintProfile implements IPrintProfile {
    @Override
    public void print() {
        System.out.println("Printing with ABS");
    }

    @Override
    public int getNozzleTemperature() {
        return 250;
    }

    @Override
    public int getBedTemperature() {
        return 100;
    }
}
