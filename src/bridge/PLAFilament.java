package bridge;

public class PLAFilament implements IFilament {
    @Override
    public String getType() {
        return "PLA";
    }

    @Override
    public int getExtruderTemperature() {
        return 200;
    }

    @Override
    public int getBedTemperature() {
        return 60;
    }

    @Override
    public int getPrintSpeed() {
        return 60;
    }

    @Override
    public void coolLayer() {
        System.out.println("Обдув 100%");
    }
}
