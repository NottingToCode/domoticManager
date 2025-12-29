package domoticManager.devices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domoticManager.factory.DomoticDeviceFactory;

public class FanTest {

	private DomoticDeviceFactory factory;
	private Fan fan;

	@Before
	public void setup() {
		factory = new DomoticDeviceFactory();
		fan = (Fan) factory.createFan("fan1");
	}

	@Test
	public void testGetFanName() {
		assertEquals("fan1", fan.getName());
	}

	@Test
	public void testIsOffInitially() {
		assertFalse(fan.isOn());
	}

	@Test
	public void testGetInitalFanSpeed() {
		assertEquals(0, fan.getFanSpeed());
	}

	@Test
	public void testMaxValue() {
		assertEquals(3, fan.getMaxValue());
	}

	@Test
	public void testSetFanSpeed() {
		fan.setFanSpeed(2);
		assertEquals(2, fan.getFanSpeed());
	}

	@Test
	public void testSetFanSpeedIfOver3() {
		fan.setFanSpeed(4);
		assertEquals(3, fan.getFanSpeed());
	}

	@Test
	public void testSetFanSpeedIfUnder0() {
		fan.setFanSpeed(-1);
		assertEquals(0, fan.getFanSpeed());
	}

	@Test
	public void testTurnOn() {
		fan.turnOn();
		assertTrue(fan.isOn());
	}

	@Test
	public void testTurnOff() {
		fan.turnOff();
		assertFalse(fan.isOn());
	}

}
