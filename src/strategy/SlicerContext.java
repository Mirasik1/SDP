package strategy;

public class SlicerContext {
    private IPrintStrategy printStrategy;

    public SlicerContext(IPrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    public void setPrintStrategy(IPrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    public PrintConfig prepareSlicingProfile(double modelVolumeCm3) {
        if (printStrategy == null) {
            throw new IllegalStateException("Стратегия печати не установлена");
        }
        return printStrategy.calculatePrintConfig(modelVolumeCm3);
    }

    public String getCurrentFilamentType() {
        return printStrategy != null ? printStrategy.getFilamentTypeName() : "None";
    }
}
