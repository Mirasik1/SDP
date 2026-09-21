package factory.abstract_factory.factory;

import factory.abstract_factory.product.INozzle;
import factory.product.IPrintProfile;

public interface IPrintEquipmentFactory {
    IPrintProfile createPrintProfile();
    INozzle createNozzle();
}