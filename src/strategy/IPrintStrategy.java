package strategy;

public interface IPrintStrategy {
    PrintConfig calculatePrintConfig(double modelVolumeCm3);
    String getFilamentTypeName();
}
