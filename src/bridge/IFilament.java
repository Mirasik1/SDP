package bridge;

public interface IFilament {
    String getType();
    int getExtruderTemperature();
    int getBedTemperature();
    int getPrintSpeed();
    void coolLayer();
}
