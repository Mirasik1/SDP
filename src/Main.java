import model.Filament;
import model.FilamentBuilder;
import model.FilamentDirector;

import java.nio.file.FileAlreadyExistsException;

public class Main {
    public static void main(String[] args) {




        FilamentDirector director = new FilamentDirector();

        Filament standardPLA = director.createStandardPLA(new FilamentBuilder());
        Filament standardABS = director.createStandardABS(new FilamentBuilder());
        Filament standardTPU = director.createStandardTPU(new FilamentBuilder());

        try {
            Filament customPetG = new FilamentBuilder()
                    .setName("Pet G")
                    .setManufacturerName("Bamboo")
                    .setBedTemperature(60)
                    .setNozzleTemperature(86)
                    .setWeightGram(1000)
                    .setPricePerKg(2000)
                    .setColor("Red")
                    .setFlexible(false)
                    .build();

            System.out.println("Создан филамент: " + customPetG);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }


        System.out.println(standardPLA);

        System.out.println(standardABS);

        System.out.println(standardTPU);



    }
}