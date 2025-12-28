package domoticManager;


public interface AbstractDeviceFactory {
	Regulator createLight(String name);

	Regulator createRadiator(String name);

	Regulator createFan(String name);

	AbstractSensor<Double> createHeatSensor(String name);

	AbstractSensor<Boolean> createMotionSensor(String name);

	DomoticDevice createGroup(String name);
}