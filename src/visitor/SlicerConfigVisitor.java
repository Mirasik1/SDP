package visitor;

public class SlicerConfigVisitor implements IFilamentVisitor {

    @Override
    public void visit(PlaFilament pla) {
        System.out.println("[Slicer Config] PLA (" + pla.getColor() + "): Nozzle 200°C, Bed 60°C, Speed 150mm/s. PEI Bed: " + pla.isTexturedPEINeeded());
    }

    @Override
    public void visit(PetgFilament petg) {
        System.out.println("[Slicer Config] PETG: Nozzle " + petg.getRecommendedNozzleTemp() + "°C, Bed 80°C, Speed 80mm/s. Retraction 2mm.");
    }

    @Override
    public void visit(TpuFilament tpu) {
        System.out.println("[Slicer Config] TPU (Hardness " + tpu.getShoreHardness() + "A): Nozzle 225°C, Bed 50°C, Low Speed 25mm/s. Direct Drive recommended.");
    }
}