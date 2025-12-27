package domoticManager.observer;

import domoticManager.DomoticDevice;
import domoticManager.sensors.AbstractSensor;

public class BooleanObserver implements IObserver {
    
    private final DomoticDevice device;
    private final AbstractSensor<Boolean> sensor;

    public BooleanObserver(DomoticDevice device, AbstractSensor<Boolean> sensor) {
        this.device = device;
        this.sensor = sensor;
    }

    @Override
    public void update() {
        if (sensor.getValue()) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}