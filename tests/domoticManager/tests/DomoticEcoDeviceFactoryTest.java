package domoticManager.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import domoticManager.DomoticDevice;
import domoticManager.devices.Regulator;
import domoticManager.factory.AbstractDeviceFactory;
import domoticManager.factory.DomoticEcoDeviceFactory;
import domoticManager.sensors.AbstractSensor;

public class DomoticEcoDeviceFactoryTest {

	private AbstractDeviceFactory factory;

	@Before
	public void setup() {
		factory = new DomoticEcoDeviceFactory();
	}

	@Test
	public void testCreateLight() {
		Regulator light = factory.createLight("LuceEco");
		assertEquals("ECO-LuceEco", light.getName());

		light.setValue(100);
		assertEquals(60, light.getValue());
	}

	@Test
	public void testCreateRadiator() {
		Regulator radiator = factory.createRadiator("TermoEco");
		assertEquals("ECO-TermoEco", radiator.getName());

		radiator.setValue(100);
		assertEquals(60, radiator.getValue());
	}

	@Test
	public void testCreateFan() {
		Regulator fan = factory.createFan("VentolaEco");
		assertEquals("ECO-VentolaEco", fan.getName());

		fan.setValue(3);
		assertEquals(2, fan.getValue());
	}

	@Test
	public void testCreateHeatSensor() {
		AbstractSensor<Double> sensor = factory.createHeatSensor("SensoreTemp");
		assertEquals("ECO-SensoreTemp", sensor.getName());
		assertEquals(0.0, sensor.getValue(), 0.01);
	}

	@Test
	public void testCreateMotionSensor() {
		AbstractSensor<Boolean> sensor = factory.createMotionSensor("SensoreMov");
		assertEquals("ECO-SensoreMov", sensor.getName());
		assertFalse(sensor.getValue());
	}

	@Test
	public void testCreateGroup() {
		DomoticDevice group = factory.createGroup("GruppoEco");
		assertEquals("ECO-GruppoEco", group.getName());
		assertFalse(group.isOn());
	}
}