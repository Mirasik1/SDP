import factory.creator.AbsProfileFactory;
import factory.creator.PlaProfileFactory;
import factory.creator.PrintProfileFactory;


public class Main {
    public static void main(String[] args) {


        PrintProfileFactory plaFactory = new PlaProfileFactory();
        plaFactory.startPrintingProcess();

        PrintProfileFactory absFactory = new AbsProfileFactory();
        absFactory.startPrintingProcess();
    }
}