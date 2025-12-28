package domoticManager.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domoticManager.factory.DomoticDeviceFactory;
import domoticManager.sensors.HeatSensor;

public class HeatSensorTest {

	private DomoticDeviceFactory factory;
	private HeatSensor thermometer;

	@Before
	public void setup() {
		factory = new DomoticDeviceFactory();
		thermometer = (HeatSensor) factory.createHeatSensor("Termometro1");
	}

	@Test
	public void testTermometerName() {
		assertEquals("Termometro1", thermometer.getName());
	}

	@Test
	public void testIsOffInitially() {
		assertFalse(thermometer.isOn());
	}

	@Test
	public void testTurnOn() {
		thermometer.turnOn();
		assertTrue(thermometer.isOn());
	}

	@Test
	public void testTurnOff() {
		thermometer.turnOn();
		thermometer.turnOff();
		assertFalse(thermometer.isOn());
	}

	@Test
	public void testInitialTemperature() {
		assertEquals(0.0, thermometer.getTemperature(), 0.001);
	}

	@Test
	public void testSetTemperature() {
		thermometer.updateValue(25.5);
		assertEquals(25.5, thermometer.getTemperature(), 0.001);
	}

	@Test
	public void testSetTemperatureIfOver50() {
		thermometer.updateValue(60.0);
		assertEquals(50.0, thermometer.getTemperature(), 0.001);
	}

	@Test
	public void testSetTemperatureIfUnder15() {
		thermometer.updateValue(-20.0);
		assertEquals(-15.0, thermometer.getTemperature(), 0.001);
	}
}
