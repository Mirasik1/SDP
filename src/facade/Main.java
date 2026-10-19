package facade;

public class Main {
    public static void main(String[] args) {
        SmartPrinterFacade printerFacade = new SmartPrinterFacade();

        printerFacade.startPrintWorkflow("gear_component.stl", "ABS", "Functional");
        System.out.println();
        printerFacade.startPrintWorkflow("cat_figurine.stl", "PLA", "Prototype");
        System.out.println();
        printerFacade.startPrintWorkflow("document.docx", "Plastic", "Fundament");
    }
}