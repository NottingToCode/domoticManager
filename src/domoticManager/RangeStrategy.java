package domoticManager;

public interface RangeStrategy {
	int apply(int value);

	int getMax();

	int getMin();
}
