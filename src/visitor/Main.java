package visitor;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IFilament> inventory = new ArrayList<>();
        inventory.add(new PlaFilament("Black", 750.0, true));
        inventory.add(new PetgFilament(450.0, 240));
        inventory.add(new TpuFilament(300.0, 95));

        IFilamentVisitor slicerVisitor = new SlicerConfigVisitor();
        IFilamentVisitor postProcessingVisitor = new PostProcessingVisitor();

        System.out.println("=== Generating Slicer Profiles ===");
        for (IFilament filament : inventory) {
            filament.accept(slicerVisitor);
        }

        System.out.println("\n=== Generating Post-Processing Instructions ===");
        for (IFilament filament : inventory) {
            filament.accept(postProcessingVisitor);
        }
    }
}