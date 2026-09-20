import factory.abstract_factory.factory.PrintEquipmentFactory;
import factory.creator.AbsProfileFactory;
import factory.creator.PlaProfileFactory;
import factory.creator.PrintProfileFactory;
import factory.abstract_factory.factory.AbsEquipmentFactory;
import factory.abstract_factory.factory.PlaEquipmentFactory;
import factory.abstract_factory.product.Nozzle;
import factory.product.PrintProfile;

public class Main {
    public static void main(String[] args) {


        PrintProfileFactory plaFactory = new AbsProfileFactory();
        plaFactory.startPrintingProcess();

        PrintProfileFactory absFactory = new AbsProfileFactory();
        absFactory.startPrintingProcess();

        PrintEquipmentFactory plaEquipment = new PlaEquipmentFactory();
        PrintProfile plaProfile = plaEquipment.createPrintProfile();
        Nozzle plaNozzle = plaEquipment.createNozzle();

        System.out.println("PLA Setup:");
        plaProfile.print();
        System.out.println("Nozzle Material: " + plaNozzle.getMaterial() + " (" + plaNozzle.getDiameter() + "mm)");
        PrintEquipmentFactory absEquipment = new AbsEquipmentFactory();
        PrintProfile absProfile = absEquipment.createPrintProfile();
        Nozzle absNozzle = absEquipment.createNozzle();

        System.out.println("ABS Setup:");
        absProfile.print();
        System.out.println("Nozzle Material: " + absNozzle.getMaterial() + " (" + absNozzle.getDiameter() + "mm)");

    }
}