package domoticManager.devices;

import java.util.function.IntUnaryOperator;

import domoticManager.AbstractDomoticDevice;
import domoticManager.Regulator;

public class Light extends AbstractDomoticDevice implements Regulator{
	
	private int brightness;
	private static final IntUnaryOperator clamp = value -> Math.max(0, Math.min(100, value));

	public Light(String name) {
		super(name);
		this.brightness = 0;
	}
	
	@Override
	public void setValue(int value) {
		this.brightness = clamp.applyAsInt(value);
	}

	@Override
	public int getValue() {
		return brightness;
	}

	@Override
	public int getMaxValue() {
		return 100;
	}
	
	public int getBrightness() {
		return getValue();
	}
	
	public void setBrightness(int brightness) {
		setValue(brightness);
	}


}
