package bridge;

public class ABSFilament implements IFilament{

    @Override
    public String getType() {
        return "ABS";
    }

    @Override
    public int getExtruderTemperature() {
        return 240;
    }

    @Override
    public int getBedTemperature() {
        return 100;
    }

    @Override
    public int getPrintSpeed() {
        return 40;
    }

    @Override
    public void coolLayer() {
        System.out.println("Обдув отключен");
    }
}
