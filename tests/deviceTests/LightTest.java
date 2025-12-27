package deviceTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domoticManager.devices.Light;
import domoticManager.factory.DomoticDeviceFactory;

public class LightTest {
	
    private DomoticDeviceFactory factory;
    private Light light; 
    
	@Before
	public void setup(){
		factory = new DomoticDeviceFactory();
		light = (Light)factory.createLight("light1");
	}

	@Test
	public void testLightName() {
		assertEquals("light1", light.getName());
	}
	
    @Test
    public void testIsOffInitially() { 
        assertFalse(light.isOn());
    }
    
    @Test
    public void testTurnOn() {
        light.turnOn();
        assertTrue(light.isOn());
    }
    
	@Test
	public void testTurnOff() {
        light.turnOn();
        light.turnOff();
        assertFalse(light.isOn());
	}
	
	@Test
	public void testInitialBrightness() {
		assertEquals(0, light.getBrightness());
	}

	@Test
	public void testSetBrightness() {
		light.setBrightness(50);
		assertEquals(50, light.getBrightness());
	}
	
	@Test
	public void testMaxValue() {
		assertEquals(100, light.getMaxValue());
	}
	
	@Test
	public void testSetBrightnessIfNegative() {
		light.setBrightness(-10);
		assertEquals(0, light.getBrightness());
	}
	
	@Test
	public void testSetBrightnessIfOver100() {
		light.setBrightness(150);
		assertEquals(100, light.getBrightness());
	}
}