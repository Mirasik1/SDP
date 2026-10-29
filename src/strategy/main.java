package strategy;

public class main {
    public static void main(String[] args) {
        double modelVolume = 45.0;

        SlicerContext slicer = new SlicerContext(new PlaPrintStrategy());
        System.out.println("Пластик: " + slicer.getCurrentFilamentType());
        System.out.println(slicer.prepareSlicingProfile(modelVolume));

        slicer.setPrintStrategy(new PetGPrintStrategy());
        System.out.println("\nСмена пластика: " + slicer.getCurrentFilamentType());
        System.out.println(slicer.prepareSlicingProfile(modelVolume));

        slicer.setPrintStrategy(new TpuPrintStrategy());
        System.out.println("\nСмена пластика: " + slicer.getCurrentFilamentType());
        System.out.println(slicer.prepareSlicingProfile(modelVolume));
    }
}
