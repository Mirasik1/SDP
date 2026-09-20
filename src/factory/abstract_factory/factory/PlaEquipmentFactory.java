package factory.abstract_factory.factory;

import factory.abstract_factory.product.Nozzle;
import factory.product.PrintProfile;
import factory.abstract_factory.product.BrassNozzle;
import factory.abstract_factory.product.Nozzle;
import factory.product.PlaPrintProfile;
import factory.product.PrintProfile;

public class PlaEquipmentFactory implements PrintEquipmentFactory{
    @Override
    public PrintProfile createPrintProfile() {
        return new PlaPrintProfile();
    }

    @Override
    public Nozzle createNozzle() {
        return new BrassNozzle();
    }
}
