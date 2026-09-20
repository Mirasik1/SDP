package factory.abstract_factory.factory;

import factory.abstract_factory.product.Nozzle;
import factory.product.PrintProfile;

public interface PrintEquipmentFactory {
    PrintProfile createPrintProfile();
    Nozzle createNozzle();
}