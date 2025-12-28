package domoticManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domoticManager.composite.DomoticGroup;
import domoticManager.devices.Fan;
import domoticManager.devices.Light;
import domoticManager.factory.DomoticDeviceFactory;

public class DomoticGroupTest {

	private DomoticDeviceFactory factory;
	private DomoticGroup group;
	private Light light;
	private Fan fan;

	@Before
	public void setup() {
		factory = new DomoticDeviceFactory();
		group = (DomoticGroup) factory.createGroup("bed room");

		light = (Light) factory.createLight("bed room light");
		fan = (Fan) factory.createFan("bed room fan");
	}

	@Test
	public void testInitialGroupName() {
		assertEquals("bed room", group.getName());
	}

	@Test
	public void testInitialGroupEmpty() {
		assertEquals(0, group.stream().count());
	}

	@Test
	public void testInitialStateIsOff() {
		assertFalse(group.isOn());
	}

	@Test
	public void testAddDevice() {
		group.addDevice(light);
		group.addDevice(fan);

		assertEquals(2, group.stream().count());
	}

	@Test
	public void testRemoveDevice() {
		group.addDevice(light);
		group.addDevice(fan);

		group.removeDevice(fan);

		assertEquals(1, group.stream().count());
	}

	@Test
	public void testGroupTurnOn() {
		group.addDevice(light);
		group.addDevice(fan);

		group.turnOn();

		assertTrue(group.isOn());
		assertTrue(light.isOn());
		assertTrue(fan.isOn());
	}

	@Test
	public void testGroupTurnOff() {
		group.addDevice(light);
		group.addDevice(fan);

		group.turnOn();

		assertTrue(group.isOn());

		group.turnOff();

		assertFalse(group.isOn());
		assertFalse(light.isOn());
		assertFalse(fan.isOn());
	}

	@Test
	public void testNestedGroups() {
		DomoticGroup firstFloorGroup = (DomoticGroup) factory.createGroup("first floor");
		group.addDevice(light);
		group.addDevice(fan);

		firstFloorGroup.addDevice(group);

		firstFloorGroup.turnOn();

		assertTrue(light.isOn());
		assertTrue(fan.isOn());
	}

	@Test
	public void testMultipleSameClassDeviceTurnOn() {
		Light rightLight = (Light) factory.createLight("rightLight");
		Light leftLight = (Light) factory.createLight("leftLight");
		Light upLight = (Light) factory.createLight("upLight");

		group.addDevice(rightLight);
		group.addDevice(leftLight);
		group.addDevice(upLight);

		assertEquals(3, group.stream().count());

		group.turnOn();

		assertTrue(rightLight.isOn());
		assertTrue(leftLight.isOn());
		assertTrue(upLight.isOn());
	}

}
