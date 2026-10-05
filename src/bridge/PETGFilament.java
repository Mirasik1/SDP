package bridge;

public class PETGFilament implements IFilament{

    @Override
    public String getType() {
        return "PETG";
    }

    @Override
    public int getExtruderTemperature() {
        return 230;
    }

    @Override
    public int getBedTemperature() {
        return 80;
    }

    @Override
    public int getPrintSpeed() {
        return 50;
    }

    @Override
    public void coolLayer() {
        System.out.println("Обдув 50%");
    }
}
