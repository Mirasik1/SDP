import model.Filament;
import model.FilamentBuilder;

import java.nio.file.FileAlreadyExistsException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FilamentBuilder builder = new FilamentBuilder();
        builder = builder.setName("PLA");
        builder = builder.setManufacturerName("3D Flash");
        builder = builder.setNozzleTemperature(215);
        builder = builder.setBedTemperature(55);
        builder = builder.setPricePerKg(7800);
        builder = builder.setWeightGram(1000);
        builder = builder.setColor("White");
        builder = builder.setFlexible(false);

        Filament PLA = new Filament(builder);
        System.out.println(PLA.getName()+PLA.getManufacturerName()+PLA.getBedTemperature()+PLA.getNozzleTemperature()+PLA.getWeightGram()+PLA.getPricePerKg()+PLA.isFlexible()+PLA.getColor());
    }
}