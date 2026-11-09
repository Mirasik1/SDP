package visitor;

public class TpuFilament implements IFilament {
    private final double remainingWeightGrams;
    private final int shoreHardness; // e.g., 95A

    public TpuFilament(double remainingWeightGrams, int shoreHardness) {
        this.remainingWeightGrams = remainingWeightGrams;
        this.shoreHardness = shoreHardness;
    }

    public double getRemainingWeightGrams() {
        return remainingWeightGrams;
    }

    public int getShoreHardness() {
        return shoreHardness;
    }

    @Override
    public void accept(IFilamentVisitor visitor) {
        visitor.visit(this);
    }
}