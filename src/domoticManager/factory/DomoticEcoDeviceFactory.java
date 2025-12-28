package domoticManager.factory;

import domoticManager.DomoticDevice;
import domoticManager.composite.DomoticGroup;
import domoticManager.devices.Fan;
import domoticManager.devices.Light;
import domoticManager.devices.Radiator;
import domoticManager.devices.Regulator;
import domoticManager.sensors.AbstractSensor;
import domoticManager.sensors.HeatSensor;
import domoticManager.sensors.MotionSensor;
import domoticManager.strategy.EcoModeStrategy;

public class DomoticEcoDeviceFactory implements AbstractDeviceFactory {

	@Override
	public Regulator createLight(String name) {
		return new Light("ECO-" + name, new EcoModeStrategy(0, 100, 60));
	}

	@Override
	public Regulator createRadiator(String name) {
		return new Radiator("ECO-" + name, new EcoModeStrategy(0, 100, 60));
	}

	@Override
	public Regulator createFan(String name) {
		return new Fan("ECO-" + name, new EcoModeStrategy(0, 3, 2));
	}

	@Override
	public AbstractSensor<Double> createHeatSensor(String name) {
		return new HeatSensor("ECO-" + name);
	}

	@Override
	public AbstractSensor<Boolean> createMotionSensor(String name) {
		return new MotionSensor("ECO-" + name);
	}

	@Override
	public DomoticDevice createGroup(String name) {
		return new DomoticGroup("ECO-" + name);
	}
}