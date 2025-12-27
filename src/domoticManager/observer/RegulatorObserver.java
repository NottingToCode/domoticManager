package domoticManager.observer;

import domoticManager.Regulator;
import domoticManager.sensors.AbstractSensor;

public class RegulatorObserver implements IObserver {
    
    private final Regulator device; 
    private final AbstractSensor<Double> sensor;
    private final double threshold;
    private final boolean activeBelowThreshold;

    public RegulatorObserver(Regulator device, AbstractSensor<Double> sensor, double threshold, boolean activeBelowThreshold) {
        this.device = device;
        this.sensor = sensor;
        this.threshold = threshold;
        this.activeBelowThreshold = activeBelowThreshold;
    }

    @Override
    public void update() {	
        Double currentVal = sensor.getValue();

        boolean shouldActivate = activeBelowThreshold 
            ? (currentVal < threshold) 
            : (currentVal > threshold);

        if (shouldActivate) {
          device.turnOn();
          device.setValue(device.getMaxValue());
        }else {
        	device.turnOff();
        }
    }
}