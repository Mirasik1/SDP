package bridge;

public class FunctionalPrintJob extends PrintJob {
    public FunctionalPrintJob(IFilament filament) {
        super(filament);
    }

    @Override
    public void printModel(String modelName) {
        System.out.println("Печать функциональной детали: " + modelName);
        System.out.println("Материал: " + filament.getType());
        System.out.println("Нагрев экструдера: " + filament.getExtruderTemperature() + "C, стола: " + filament.getBedTemperature() + "C");
        System.out.println("Точная скорость: " + filament.getPrintSpeed() + " мм/с с высокой плотностью заполнения");
        filament.coolLayer();
        System.out.println("Функциональная деталь " + modelName + " успешно напечатана\n");
    }
}