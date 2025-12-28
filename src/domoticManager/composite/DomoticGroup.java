package domoticManager.composite;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import domoticManager.DomoticDevice;
import domoticManager.devices.AbstractDomoticDevice;

public class DomoticGroup extends AbstractDomoticDevice {

	private Set<DomoticDevice> children;

	public DomoticGroup(String name) {
		super(name);
		this.children = new LinkedHashSet<>();
	}
	
	public void addDevice(DomoticDevice device) {
		children.add(device);
	}

	public void removeDevice(DomoticDevice device) {
		children.remove(device);
	}

	public Stream<DomoticDevice> stream() {
		return children.stream();
	}

	@Override
	public void turnOn() {
		super.turnOn();
		stream().forEach(DomoticDevice::turnOn);
	}

	@Override
	public void turnOff() {
		super.turnOff();
		stream().forEach(DomoticDevice::turnOff);
	}

}
