package domoticManager;

public class Radiator extends AbstractDomoticDevice implements Regulator {

	private int heatLevel;
	private RangeStrategy strategy;

	public Radiator(String name, RangeStrategy strategy) {
		super(name);
		this.strategy = strategy;
		this.heatLevel = 0;
	}

	@Override
	public void setValue(int value) {
		this.heatLevel = strategy.apply(value);
	}

	@Override
	public int getValue() {
		return heatLevel;
	}

	@Override
	public int getMaxValue() {
		return strategy.getMax();
	}

	public int getHeatValue() {
		return getValue();
	}

	public void setHeatValue(int heatLevel) {
		setValue(heatLevel);
	}

}