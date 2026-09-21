package factory.abstract_factory.product;

public class BrassNozzle implements INozzle {
    @Override
    public String getMaterial() {
        return "Brass";
    }

    @Override
    public double getDiameter() {
        return 0.4;
    }
}
