package domoticManager.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domoticManager.devices.Fan;
import domoticManager.devices.Radiator;
import domoticManager.factory.DomoticDeviceFactory;
import domoticManager.sensors.HeatSensor;

public class RegulatorObserverTest {

	private DomoticDeviceFactory factory;
	private HeatSensor sensor;
	private Radiator radiator;
	private Fan fan;

	@Before
	public void setup() {
		factory = new DomoticDeviceFactory();
		sensor = (HeatSensor) factory.createHeatSensor("heat sensor");
		radiator = (Radiator) factory.createRadiator("room radiator");
		fan = (Fan) factory.createFan("room fan");
	}

	@Test
	public void testHeatingLogic_Radiator() {
		IObserver heatingObserver = new RegulatorObserver(radiator, sensor, 20.0, true);
		sensor.attach(heatingObserver);

		sensor.updateValue(15.0);

		assertTrue(radiator.isOn());
		assertEquals(100, radiator.getHeatValue());
	}

	@Test
	public void testCoolingLogic_Fan() {
		IObserver coolingObserver = new RegulatorObserver(fan, sensor, 28.0, false);
		sensor.attach(coolingObserver);

		assertFalse(fan.isOn());

		sensor.updateValue(30.0);

		assertEquals(3, fan.getFanSpeed());
	}

	@Test
	public void testHeatingLogic_ShouldNotActivate_IfHot() {
		IObserver heatingObserver = new RegulatorObserver(radiator, sensor, 20.0, true);
		sensor.attach(heatingObserver);

		radiator.turnOn();

		sensor.updateValue(25.0);

		assertFalse(radiator.isOn());
	}

	@Test
	public void testCoolingLogic_ShouldNotActivate_IfCold() {
		IObserver coolingObserver = new RegulatorObserver(fan, sensor, 28.0, false);
		sensor.attach(coolingObserver);

		fan.turnOn();

		sensor.updateValue(20.0);

		assertFalse(fan.isOn());
	}

	@Test
	public void testDetachObserver() {
		IObserver heatingObserver = new RegulatorObserver(radiator, sensor, 20.0, true);
		sensor.attach(heatingObserver);

		sensor.updateValue(10.0);
		assertTrue(radiator.isOn());

		sensor.detach(heatingObserver);

		sensor.updateValue(30.0);

		assertTrue(radiator.isOn());
	}

}