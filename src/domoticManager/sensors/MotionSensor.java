package domoticManager.sensors;

public class MotionSensor extends AbstractSensor<Boolean> {

    public MotionSensor(String name) {
        super(name);
        setValue(false); 
    }

    @Override
    public void updateValue(Boolean newValue) {
        setValue(newValue); 
        notifyObservers();
    }

    public void movementDetected() {
        updateValue(true);
    }

    public void reset() {
        updateValue(false);
    }
}