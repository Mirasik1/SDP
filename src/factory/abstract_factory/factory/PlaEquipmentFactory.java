package factory.abstract_factory.factory;

import factory.abstract_factory.product.INozzle;
import factory.product.IPrintProfile;
import factory.abstract_factory.product.BrassNozzle;
import factory.product.PlaPrintProfile;

public class PlaEquipmentFactory implements IPrintEquipmentFactory {
    @Override
    public IPrintProfile createPrintProfile() {
        return new PlaPrintProfile();
    }

    @Override
    public INozzle createNozzle() {
        return new BrassNozzle();
    }
}
