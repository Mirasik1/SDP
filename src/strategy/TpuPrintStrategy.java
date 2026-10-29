package strategy;

public class TpuPrintStrategy implements IPrintStrategy{
    @Override
    public PrintConfig calculatePrintConfig(double modelVolumeCm3) {
        int nozzleTemp = 225;
        int bedTemp = 50;
        double time = (modelVolumeCm3 * 6);
        return new PrintConfig(nozzleTemp, bedTemp, (int) time);
    }

    @Override
    public String getFilamentTypeName() {
        return "TPU";
    }
}
