package domoticManager.factory;

import domoticManager.DomoticDevice;
import domoticManager.Regulator;
import domoticManager.composite.DomoticGroup;
import domoticManager.devices.Fan;
import domoticManager.devices.Light;
import domoticManager.devices.Radiator;
import domoticManager.sensors.AbstractSensor;
import domoticManager.sensors.HeatSensor;
import domoticManager.sensors.MotionSensor;
import strategy.StandardRangeStrategy;

public class DomoticDeviceFactory implements AbstractDeviceFactory {


    @Override
    public AbstractSensor<Double> createHeatSensor(String name) {
        return new HeatSensor(name);
    }
    
    @Override
    public Regulator createLight(String name) {
        return new Light(name, new StandardRangeStrategy(0, 100));
    }
    
    @Override
    public Regulator createRadiator(String name) {
        return new Radiator(name, new StandardRangeStrategy(0, 100));
    }
    
    @Override
    public Regulator createFan(String name) {
        return new Fan(name,  new StandardRangeStrategy(0, 3));
    }

    @Override
    public AbstractSensor<Boolean> createMotionSensor(String name) {
        return new MotionSensor(name);
    }

    @Override
    public DomoticDevice createGroup(String name) {
        return new DomoticGroup(name);
    }
}