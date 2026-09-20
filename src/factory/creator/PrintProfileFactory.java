package factory.creator;

import factory.product.PrintProfile;

public abstract class PrintProfileFactory{

    public abstract PrintProfile createProfile();

    public void startPrintingProcess() {
        PrintProfile profile = createProfile();
        System.out.println("Starting calibration for nozzle at " + profile.getNozzleTemperature() + "°C...");
        profile.print();
    }

}
