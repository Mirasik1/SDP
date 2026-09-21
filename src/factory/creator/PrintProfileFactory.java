package factory.creator;

import factory.product.IPrintProfile;

public abstract class PrintProfileFactory{

    public abstract IPrintProfile createProfile();

    public void startPrintingProcess() {
        IPrintProfile profile = createProfile();
        System.out.println("Starting calibration for nozzle at " + profile.getNozzleTemperature() + "°C...");
        profile.print();
    }

}
