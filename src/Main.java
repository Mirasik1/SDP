import factory.abstract_factory.factory.IPrintEquipmentFactory;
import factory.creator.AbsProfileFactory;
import factory.creator.PrintProfileFactory;
import factory.abstract_factory.factory.AbsEquipmentFactory;
import factory.abstract_factory.factory.PlaEquipmentFactory;
import factory.abstract_factory.product.INozzle;
import factory.product.IPrintProfile;

public class Main {
    public static void main(String[] args) {


        PrintProfileFactory plaFactory = new AbsProfileFactory();
        plaFactory.startPrintingProcess();

        PrintProfileFactory absFactory = new AbsProfileFactory();
        absFactory.startPrintingProcess();

        IPrintEquipmentFactory plaEquipment = new PlaEquipmentFactory();
        IPrintProfile plaProfile = plaEquipment.createPrintProfile();
        INozzle plaNozzle = plaEquipment.createNozzle();

        System.out.println("PLA Setup:");
        plaProfile.print();
        System.out.println("Nozzle Material: " + plaNozzle.getMaterial() + " (" + plaNozzle.getDiameter() + "mm)");
        IPrintEquipmentFactory absEquipment = new AbsEquipmentFactory();
        IPrintProfile absProfile = absEquipment.createPrintProfile();
        INozzle absNozzle = absEquipment.createNozzle();

        System.out.println("ABS Setup:");
        absProfile.print();
        System.out.println("Nozzle Material: " + absNozzle.getMaterial() + " (" + absNozzle.getDiameter() + "mm)");

    }
}