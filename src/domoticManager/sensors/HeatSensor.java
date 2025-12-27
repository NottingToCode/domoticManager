package domoticManager.sensors;

import java.util.function.DoubleUnaryOperator;

public class HeatSensor extends AbstractSensor<Double>{
	
	
	private static final DoubleUnaryOperator clamp = value -> Math.max(-15,Math.min(50, value));

	public HeatSensor(String name) {
		super(name);
		this.value = 0.0;
	}
	
	public double getTemperature() {
		return getValue();
	}

	@Override
	public void updateValue(Double newValue) {
		this.value = clamp.applyAsDouble(newValue);
		notifyObservers();
	}

}
