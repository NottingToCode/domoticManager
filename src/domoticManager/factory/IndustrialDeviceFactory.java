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

public class IndustrialDeviceFactory implements AbstractDeviceFactory {

	@Override
	public Regulator createLight(String name) {
		return new Light("INDUSTRIAL-" + name);
	}

	@Override
	public Regulator createRadiator(String name) {
		return new Radiator("INDUSTRIAL-" + name, new StandardRangeStrategy(0, 300));
	}

	@Override
	public Regulator createFan(String name) {
		return new Fan("INDUSTRIAL-" + name, new StandardRangeStrategy(0, 10));
	}

	@Override
	public AbstractSensor<Double> createHeatSensor(String name) {
		return new HeatSensor("INDUSTRIAL-" + name);
	}

	@Override
	public AbstractSensor<Boolean> createMotionSensor(String name) {
		return new MotionSensor("INDUSTRIAL-" + name);
	}

	@Override
	public DomoticDevice createGroup(String name) {
		return new DomoticGroup("INDUSTRIAL-" + name);
	}

}