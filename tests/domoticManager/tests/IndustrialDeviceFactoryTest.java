package domoticManager.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domoticManager.DomoticDevice;
import domoticManager.devices.Regulator;
import domoticManager.factory.AbstractDeviceFactory;
import domoticManager.factory.IndustrialDeviceFactory;
import domoticManager.sensors.AbstractSensor;

public class IndustrialDeviceFactoryTest {

	private AbstractDeviceFactory factory;

	@Before
	public void setup() {
		factory = new IndustrialDeviceFactory();
	}

	@Test
	public void testCreateLightHasIndustrialPrefix() {
		Regulator light = factory.createLight("Light");
		assertEquals("INDUSTRIAL-Light", light.getName());
	}

	@Test
	public void testCreateRadiatorHasIndustrialPrefix() {
		Regulator radiator = factory.createRadiator("Radiator");
		assertEquals("INDUSTRIAL-Radiator", radiator.getName());
	}

	@Test
	public void testCreateFanHasIndustrialPrefix() {
		Regulator fan = factory.createFan("fan");
		assertEquals("INDUSTRIAL-fan", fan.getName());
	}

	@Test
	public void testCreateHeatSensorHasIndustrialPrefix() {
		AbstractSensor<Double> sensor = factory.createHeatSensor("HeatSensor");
		assertEquals("INDUSTRIAL-HeatSensor", sensor.getName());
	}

	@Test
	public void testCreateMotionSensorHasIndustrialPrefix() {
		AbstractSensor<Boolean> sensor = factory.createMotionSensor("MotionSensor");
		assertEquals("INDUSTRIAL-MotionSensor", sensor.getName());
	}

	@Test
	public void testCreateGroupHasIndustrialPrefix() {
		DomoticDevice group = factory.createGroup("Room");
		assertEquals("INDUSTRIAL-Room", group.getName());
	}
}