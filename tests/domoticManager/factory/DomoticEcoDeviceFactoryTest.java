package domoticManager.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import domoticManager.DomoticDevice;
import domoticManager.devices.Regulator;
import domoticManager.sensors.AbstractSensor;

public class DomoticEcoDeviceFactoryTest {

	private AbstractDeviceFactory factory;

	@Before
	public void setup() {
		factory = new DomoticEcoDeviceFactory();
	}

	@Test
	public void testCreateLight() {
		Regulator light = factory.createLight("light");
		assertEquals("ECO-light", light.getName());

		light.setValue(100);
		assertEquals(60, light.getValue());
	}

	@Test
	public void testCreateRadiator() {
		Regulator radiator = factory.createRadiator("radiator");
		assertEquals("ECO-radiator", radiator.getName());

		radiator.setValue(100);
		assertEquals(60, radiator.getValue());
	}

	@Test
	public void testCreateFan() {
		Regulator fan = factory.createFan("fan");
		assertEquals("ECO-fan", fan.getName());

		fan.setValue(3);
		assertEquals(2, fan.getValue());
	}

	@Test
	public void testCreateHeatSensor() {
		AbstractSensor<Double> sensor = factory.createHeatSensor("heatSensor");
		assertEquals("ECO-heatSensor", sensor.getName());
		assertEquals(0.0, sensor.getValue(), 0.01);
	}

	@Test
	public void testCreateMotionSensor() {
		AbstractSensor<Boolean> sensor = factory.createMotionSensor("motionSensor");
		assertEquals("ECO-motionSensor", sensor.getName());
		assertFalse(sensor.getValue());
	}

	@Test
	public void testCreateGroup() {
		DomoticDevice group = factory.createGroup("group");
		assertEquals("ECO-group", group.getName());
		assertFalse(group.isOn());
	}
}