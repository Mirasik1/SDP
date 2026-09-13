package model;

import model.Filament;
import model.FilamentBuilder;

public class FilamentDirector {
    public Filament createStandardPLA(FilamentBuilder builder){
        return builder
                .setName("Generic PLA")
                .setManufacturerName("Bamboo")
                .setNozzleTemperature(215)
                .setBedTemperature(45)
                .setPricePerKg(8000)
                .setWeightGram(1000)
                .setColor("White")
                .setFlexible(false)
                .build();
    }
    public Filament createStandardABS(FilamentBuilder builder){
        return builder
                .setName("ABS")
                .setManufacturerName("3D Flash")
                .setNozzleTemperature(250)
                .setBedTemperature(100)
                .setPricePerKg(9000)
                .setWeightGram(1000)
                .setColor("Black")
                .setFlexible(false)
                .build();
    }
    public Filament createStandardTPU(FilamentBuilder builder){
        return builder
                .setName("TPU")
                .setManufacturerName("KZ Plastic")
                .setNozzleTemperature(230)
                .setBedTemperature(50)
                .setPricePerKg(12000)
                .setWeightGram(1000)
                .setColor("Red")
                .setFlexible(true)
                .build();
    }
}
