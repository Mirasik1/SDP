package bridge;

public class Main {
    public static void main(String[] args) {
        IFilament pla = new PLAFilament();
        IFilament abs = new ABSFilament();
        IFilament petg = new PETGFilament();

        PrintJob rapidPrototype = new PrototypePrintJob(pla);
        rapidPrototype.printModel("Корпус тестовый");

        rapidPrototype.setFilament(petg);
        rapidPrototype.printModel("Корпус тестовый v2");

        PrintJob gears = new FunctionalPrintJob(abs);
        gears.printModel("Шестеренка редуктора");
    }
}