package model;

public class FilamentBuilder {
    String name;
    String manufacturerName;
    float nozzleTemperature;
    float bedTemperature;
    float pricePerKg;
    float weightGram;
    String color="White";
    boolean isFlexible=false;


    public FilamentBuilder setName(String name){
        this.name = name;
        return this;
    }


    public FilamentBuilder setManufacturerName(String manufacturerName){
        this.manufacturerName = manufacturerName;
        return this;
    }


    public FilamentBuilder setNozzleTemperature(float nozzleTemperature){
        this.nozzleTemperature = nozzleTemperature;
        return this;
    }


    public FilamentBuilder setBedTemperature(float bedTemperature){
        this.bedTemperature = bedTemperature;
        return this;
    }


    public FilamentBuilder setPricePerKg(float pricePerKg){
        this.pricePerKg = pricePerKg;
        return this;
    }

    public FilamentBuilder setWeightGram(float weightGram){
        this.weightGram = weightGram;
        return this;
    }

    public FilamentBuilder setColor(String color){
        this.color = color;
        return this;
    }

    public FilamentBuilder setFlexible(boolean isFlexible) {
        this.isFlexible = isFlexible;
        return this;
    }

    public Filament build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Filament name cannot be empty");
        }
        if (nozzleTemperature < 150 || nozzleTemperature > 450) {
            throw new IllegalArgumentException("Invalid nozzle temperature: " + nozzleTemperature);
        }
        if (manufacturerName == null || manufacturerName.trim().isEmpty()) {
            throw new IllegalStateException("Filament Manufacturer name cannot be empty");
        }
        if (bedTemperature < 20 || bedTemperature > 150) {
            throw new IllegalArgumentException("Invalid nozzle temperature: " + bedTemperature);
        }
        return new Filament(this);
    }





}
