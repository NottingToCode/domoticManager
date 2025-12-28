package domoticManager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domoticManager.devices.Light;
import domoticManager.factory.DomoticDeviceFactory;
import domoticManager.observer.BooleanObserver;
import domoticManager.observer.IObserver;
import domoticManager.sensors.MotionSensor;

public class BooleanObserverTest {

	private DomoticDeviceFactory factory;
	private MotionSensor sensor;
	private Light light;

	@Before
	public void setup() {
		factory = new DomoticDeviceFactory();

		sensor = (MotionSensor) factory.createMotionSensor("Sensore Ingresso");
		light = (Light) factory.createLight("Luce Ingresso");
	}

	@Test
	public void testTurnOn_WhenSensorIsTrue() {
		IObserver observer = new BooleanObserver(light, sensor);
		sensor.attach(observer);

		assertFalse(light.isOn());

		sensor.updateValue(true);

		assertTrue(light.isOn());
	}

	@Test
	public void testTurnOff_WhenSensorIsFalse() {
		IObserver observer = new BooleanObserver(light, sensor);
		sensor.attach(observer);

		sensor.updateValue(true);
		assertTrue(light.isOn());

		sensor.updateValue(false);

		assertFalse(light.isOn());
	}

	@Test
	public void testDetach_StopsUpdates() {
		IObserver observer = new BooleanObserver(light, sensor);
		sensor.attach(observer);

		sensor.updateValue(true);
		assertTrue(light.isOn());

		sensor.detach(observer);

		sensor.updateValue(false);

		assertTrue("Il dispositivo NON dovrebbe reagire dopo il detach", light.isOn());
	}
}