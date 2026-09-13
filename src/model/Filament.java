package model;

public class Filament {
    private String name;
    private String manufacturerName;
    private float nozzleTemperature;
    private float bedTemperature;
    private float pricePerKg;
    private float weightGram;
    private String color;
    private boolean isFlexible;

    public Filament(FilamentBuilder builder){
        this.name = builder.name;
        this.manufacturerName = builder.manufacturerName;
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

    public float getNozzleTemperature(){
        return nozzleTemperature;
    }

    public float getBedTemperature(){
        return bedTemperature;
    }

    public float getPricePerKg() {
        return pricePerKg;
    }

    public float getWeightGram() {
        return weightGram;
    }

    public String getColor(){
        return color;
    }

    public boolean isFlexible(){
        return isFlexible;
    }

    @Override
    public String toString(){
        return "Filament: " + name+
                " - Nozzle temperature: " +nozzleTemperature + "*C"+
                " - Bed temperature: " + bedTemperature + "*C"+
                " - Price: " + pricePerKg +"KZT/kg"+
                " - Weight: " +weightGram +"g"+
                " - Color: "+color+
                " - Flexible: " +isFlexible;
    }
}
