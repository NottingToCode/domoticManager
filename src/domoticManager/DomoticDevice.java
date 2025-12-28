package domoticManager;

public interface DomoticDevice {

	String getName();

	void turnOn();

	void turnOff();

	boolean isOn();

}