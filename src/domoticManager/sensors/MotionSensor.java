package domoticManager.sensors;

public class MotionSensor extends AbstractSensor<Boolean> {

	public MotionSensor(String name) {
		super(name);
		this.value = false;
	}

	@Override
	public void updateValue(Boolean newValue) {
		this.value = newValue;
		notifyObservers();
	}

	public void movementDetected() {
		updateValue(true);
	}

	public void reset() {
		updateValue(false);
	}
}
