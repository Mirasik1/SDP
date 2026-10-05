package bridge;

public class PrototypePrintJob extends PrintJob {
    public PrototypePrintJob(IFilament filament) {
        super(filament);
    }

    @Override
    public void printModel(String modelName) {
        System.out.println("Печать черновика: " + modelName);
        System.out.println("Материал: " + filament.getType());
        System.out.println("Нагрев экструдера: " + filament.getExtruderTemperature() + "C, стола: " + filament.getBedTemperature() + "C");
        System.out.println("Увеличенная скорость: " + (filament.getPrintSpeed() + 20) + " мм/с");
        filament.coolLayer();
        System.out.println("Прототип " + modelName + " успешно напечатан\n");
    }
}