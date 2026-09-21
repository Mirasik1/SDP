package factory.abstract_factory.factory;

import factory.abstract_factory.product.INozzle;
import factory.product.IPrintProfile;
import factory.abstract_factory.product.HardenedSteelNozzle;
import factory.product.AbsPrintProfile;

public class AbsEquipmentFactory implements IPrintEquipmentFactory {
    @Override
    public IPrintProfile createPrintProfile() {
        return new AbsPrintProfile();
    }

    @Override
    public INozzle createNozzle() {
        return new HardenedSteelNozzle();
    }
}
