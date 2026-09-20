package factory.abstract_factory.product;

public class HardenedSteelNozzle implements Nozzle {
    @Override
    public String getMaterial() {
        return "Hardened Steel";
    }

    @Override
    public double getDiameter() {
        return 0.3;
    }
}
