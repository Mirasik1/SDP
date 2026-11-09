package visitor;

public class PetgFilament implements IFilament {
    private final double remainingWeightGrams;
    private final int recommendedNozzleTemp;

    public PetgFilament(double remainingWeightGrams, int recommendedNozzleTemp) {
        this.remainingWeightGrams = remainingWeightGrams;
        this.recommendedNozzleTemp = recommendedNozzleTemp;
    }

    public double getRemainingWeightGrams() {
        return remainingWeightGrams;
    }

    public int getRecommendedNozzleTemp() {
        return recommendedNozzleTemp;
    }

    @Override
    public void accept(IFilamentVisitor visitor) {
        visitor.visit(this);
    }
}
