package domoticManager.factory;

import domoticManager.DomoticDevice;
import domoticManager.devices.Regulator;
import domoticManager.sensors.AbstractSensor;

public interface AbstractDeviceFactory {
	Regulator createLight(String name);

	Regulator createRadiator(String name);

	Regulator createFan(String name);

	AbstractSensor<Double> createHeatSensor(String name);

	AbstractSensor<Boolean> createMotionSensor(String name);

	DomoticDevice createGroup(String name);
}