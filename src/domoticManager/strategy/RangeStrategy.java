package domoticManager.strategy;

public interface RangeStrategy {
	int apply(int value);

	int getMax();

	int getMin();
}
