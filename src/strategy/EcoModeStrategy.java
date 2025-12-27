package strategy;

public class EcoModeStrategy implements RangeStrategy {

    private final int min;
    private final int max;
    private final int ecoLimit;

    public EcoModeStrategy(int min, int max, int ecoLimit) {
        this.min = min;
        this.max = max;

        this.ecoLimit = Math.min(max, ecoLimit);
    }

    @Override
    public int apply(int value) {
        int effectiveMax = this.ecoLimit;
        
        return Math.max(min, Math.min(effectiveMax, value));
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int getMin() {
        return min;
    }

    public int getEcoLimit() {
        return ecoLimit;
    }
}