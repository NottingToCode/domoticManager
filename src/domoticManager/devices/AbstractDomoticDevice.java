package domoticManager.devices;

import domoticManager.DomoticDevice;

public abstract class AbstractDomoticDevice implements DomoticDevice {

	private String name;
	private boolean on;

	public AbstractDomoticDevice(String name) {
		this.name = name;
		this.on = false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void turnOn() {
		on = true;
	}

	@Override
	public void turnOff() {
		on = false;
	}

	@Override
	public boolean isOn() {
		return on;
	}

}