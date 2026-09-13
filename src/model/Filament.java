package model;

public class Filament {
    private String name;
    private String manufacturerName;
    private double nozzleTemperature;
    private double bedTemperature;
    private double pricePerKg;
    private double weightGram;
    private String color;
    private boolean isFlexible;

    public Filament(FilamentBuilder builder){
        this.name = builder.name;
        this.nozzleTemperature = builder.nozzleTemperature;
        this.bedTemperature = builder.bedTemperature;
        this.pricePerKg = builder.pricePerKg;
        this.weightGram = builder.weightGram;
        this.color = builder.color;
        this.isFlexible = builder.isFlexible;
    }

    public String getName(){
        return name;
    }

    public String getManufacturerName(){
        return manufacturerName;
    }

    public double getNozzleTemperature(){
        return nozzleTemperature;
    }

    public double getBedTemperature(){
        return bedTemperature;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getWeightGram() {
        return weightGram;
    }

    private String getColor(){
        return color;
    }

    private boolean isFlexible(){
        return isFlexible;
    }
}
