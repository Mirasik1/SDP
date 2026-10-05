package bridge;

public abstract class PrintJob {
    protected IFilament filament;

    public PrintJob(IFilament filament) {
        this.filament = filament;
    }

    public void setFilament(IFilament filament) {
        this.filament = filament;
    }

    public abstract void printModel(String modelName);
}