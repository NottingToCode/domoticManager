package domoticManager.devices;

import domoticManager.strategy.RangeStrategy;

public class Fan extends AbstractDomoticDevice implements Regulator {

	private int fanSpeed;
	private final RangeStrategy strategy;

	public Fan(String name, RangeStrategy strategy) {
		super(name);
		this.strategy = strategy;
		this.fanSpeed = 0;
	}

	@Override
	public void setValue(int value) {
		this.fanSpeed = strategy.apply(value);
	}

	@Override
	public int getValue() {
		return fanSpeed;
	}

	@Override
	public int getMaxValue() {
		return strategy.getMax();
	}

	public void setFanSpeed(int speed) {
		setValue(speed);
	}

	public int getFanSpeed() {
		return getValue();
	}
}