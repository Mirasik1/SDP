package strategy;

public class PlaPrintStrategy implements IPrintStrategy{
    @Override
    public PrintConfig calculatePrintConfig(double modelVolumeCm3) {
        int nozzleTemp = 205;
        int bedTemp = 60;
        double time = (modelVolumeCm3 * 2.5);
        return new PrintConfig(nozzleTemp, bedTemp, (int) time);
    }

    @Override
    public String getFilamentTypeName() {
        return "PLA";
    }
}
