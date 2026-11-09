package visitor;

public class PlaFilament implements IFilament {
    private final String color;
    private final double remainingWeightGrams;
    private final boolean isTexturedPEINeeded;

    public PlaFilament(String color, double remainingWeightGrams, boolean isTexturedPEINeeded) {
        this.color = color;
        this.remainingWeightGrams = remainingWeightGrams;
        this.isTexturedPEINeeded = isTexturedPEINeeded;
    }

    public String getColor() {
        return color;
    }

    public double getRemainingWeightGrams() {
        return remainingWeightGrams;
    }

    public boolean isTexturedPEINeeded() {
        return isTexturedPEINeeded;
    }

    @Override
    public void accept(IFilamentVisitor visitor) {
        visitor.visit(this);
    }
}
