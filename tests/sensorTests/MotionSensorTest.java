package sensorTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domoticManager.factory.DomoticDeviceFactory;
import domoticManager.sensors.MotionSensor;

public class MotionSensorTest {
	
	private DomoticDeviceFactory factory;
	private MotionSensor sensor;

	@Before
	public void setup(){
		factory = new DomoticDeviceFactory();
		sensor = (MotionSensor) factory.createMotionSensor("sensore1");
	}
	
	@Test
	public void testNameSensor() {
		assertEquals("sensore1", sensor.getName());
	}

	@Test
	public void testMovementDetected() {
		sensor.movementDetected();
		assertTrue(sensor.getValue());
	}

	@Test
	public void testReset() {
		sensor.reset();
		assertFalse(sensor.getValue());
	}

}
