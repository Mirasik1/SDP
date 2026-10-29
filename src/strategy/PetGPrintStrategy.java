package strategy;

public class PetGPrintStrategy implements IPrintStrategy{
    @Override
    public PrintConfig calculatePrintConfig(double modelVolumeCm3) {
        int nozzleTemp = 240;
        int bedTemp = 75;
        double time = (modelVolumeCm3 * 3.2);
        return new PrintConfig(nozzleTemp, bedTemp, (int) time);
    }

    @Override
    public String getFilamentTypeName() {
        return "PetG";
    }
}
