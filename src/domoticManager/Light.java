package domoticManager;

public class Light extends AbstractDomoticDevice implements Regulator {

	private int brightness;
	private final RangeStrategy strategy;

	public Light(String name, RangeStrategy strategy) {
		super(name);
		this.strategy = strategy;
		this.brightness = 0;
	}

	@Override
	public void setValue(int value) {
		this.brightness = strategy.apply(value);
	}

	@Override
	public int getValue() {
		return brightness;
	}

	@Override
	public int getMaxValue() {
		return strategy.getMax();
	}

	public int getBrightness() {
		return getValue();
	}

	public void setBrightness(int brightness) {
		setValue(brightness);
	}

}
