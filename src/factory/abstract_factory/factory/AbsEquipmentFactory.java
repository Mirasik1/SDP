package factory.abstract_factory.factory;

import factory.abstract_factory.product.Nozzle;
import factory.product.PrintProfile;
import factory.abstract_factory.product.HardenedSteelNozzle;
import factory.abstract_factory.product.Nozzle;
import factory.product.AbsPrintProfile;
import factory.product.PrintProfile;
public class AbsEquipmentFactory implements PrintEquipmentFactory{
    @Override
    public PrintProfile createPrintProfile() {
        return new AbsPrintProfile();
    }

    @Override
    public Nozzle createNozzle() {
        return new HardenedSteelNozzle();
    }
}
