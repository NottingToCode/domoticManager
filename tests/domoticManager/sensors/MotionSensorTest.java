package domoticManager.sensors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domoticManager.factory.DomoticDeviceFactory;

public class MotionSensorTest {

	private DomoticDeviceFactory factory;
	private MotionSensor sensor;

	@Before
	public void setup() {
		factory = new DomoticDeviceFactory();
		sensor = (MotionSensor) factory.createMotionSensor("motion sensor");
	}

	@Test
	public void testNameSensor() {
		assertEquals("motion sensor", sensor.getName());
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
