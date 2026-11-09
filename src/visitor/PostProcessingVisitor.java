package visitor;

public class PostProcessingVisitor implements IFilamentVisitor {

    @Override
    public void visit(PlaFilament pla) {
        System.out.println("[Post-Processing] PLA: Wet sanding up to 2000 grit, acrylic primer, and varnish coating.");
    }

    @Override
    public void visit(PetgFilament petg) {
        System.out.println("[Post-Processing] PETG: Heat gun for stringing removal, mechanical sanding.");
    }

    @Override
    public void visit(TpuFilament tpu) {
        System.out.println("[Post-Processing] TPU: Minimal sanding (flexible), clean flash with sharp blade.");
    }
}
