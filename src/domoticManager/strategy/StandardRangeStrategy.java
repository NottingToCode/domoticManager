package domoticManager.strategy;

public class StandardRangeStrategy implements RangeStrategy {

	private final int min;
	private final int max;

	public StandardRangeStrategy(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public int apply(int value) {
		return Math.max(min, Math.min(max, value));
	}

	@Override
	public int getMax() {
		return max;
	}

	@Override
	public int getMin() {
		return min;
	}

}