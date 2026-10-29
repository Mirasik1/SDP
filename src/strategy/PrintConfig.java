package strategy;

public class PrintConfig {
    private final int nozzleTemperature;
    private final int bedTemperature;
    private final int estimatedTimeS;

    public PrintConfig(int nozzleTemperature, int bedTemperature, int estimatedTimeS) {
        this.nozzleTemperature = nozzleTemperature;
        this.bedTemperature = bedTemperature;
        this.estimatedTimeS = estimatedTimeS;
    }

    @Override
    public String toString() {
        return String.format("Температура сопла: %d°C Температура стола: %d°C Время Печати: %d секунд",
                nozzleTemperature, bedTemperature, estimatedTimeS);
    }
}
