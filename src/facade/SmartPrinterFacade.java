package facade;

import bridge.IFilament;
import bridge.PLAFilament;
import bridge.ABSFilament;
import bridge.PrintJob;
import bridge.PrototypePrintJob;
import bridge.FunctionalPrintJob;
import factory.abstract_factory.factory.IPrintEquipmentFactory;
import factory.abstract_factory.factory.PlaEquipmentFactory;
import factory.abstract_factory.factory.AbsEquipmentFactory;
import factory.abstract_factory.product.INozzle;
import factory.product.IPrintProfile;

public class SmartPrinterFacade {
    private final FileValidator validator;
    private final PrintNotifier notifier;

    public SmartPrinterFacade() {
        this.validator = new FileValidator();
        this.notifier = new PrintNotifier();
    }

    public void startPrintWorkflow(String modelPath, String materialType, String jobType) {
        System.out.println("=== ЗАПУСК АВТОМАТИЗИРОВАННОГО ПРОЦЕССА ПЕЧАТИ ===");

        if (!validator.validate(modelPath)) {
            notifier.notifyError("Модель не подходит по формату");
            return;
        }

        IPrintEquipmentFactory equipmentFactory;
        IFilament filament;

        if ("ABS".equalsIgnoreCase(materialType)) {
            equipmentFactory = new AbsEquipmentFactory();
            filament = new ABSFilament();
        } else {
            equipmentFactory = new PlaEquipmentFactory();
            filament = new PLAFilament();
        }

        INozzle nozzle = equipmentFactory.createNozzle();
        IPrintProfile profile = equipmentFactory.createPrintProfile();

        System.out.println("[Hardware Setup] Установлено сопло: " + nozzle.getMaterial());
        System.out.println("[Profile Config] Загружен профиль: " + profile.getNozzleTemperature());

        PrintJob job;
        if ("Functional".equalsIgnoreCase(jobType)) {
            job = new FunctionalPrintJob(filament);
        } else {
            job = new PrototypePrintJob(filament);
        }

        job.printModel(modelPath);
        notifier.notifyStart(modelPath);
        System.out.println("=================================================");
    }
}