package domoticManager.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domoticManager.DomoticDevice;
import domoticManager.devices.Regulator;
import domoticManager.sensors.AbstractSensor;

public class DomoticDeviceFactoryTest {

    private AbstractDeviceFactory factory;

    @Before
    public void setup() {
        factory = new DomoticDeviceFactory();
    }

    @Test
    public void testCreateLight() {
        Regulator light = factory.createLight("standard light");
        assertEquals("standard light", light.getName());
        
        light.setValue(100); 
        assertEquals(100, light.getValue());
    }

    @Test
    public void testCreateRadiator() {
        Regulator radiator = factory.createRadiator("radiator");
        assertEquals("radiator", radiator.getName());
        radiator.setValue(50);
        assertEquals(50, radiator.getValue());
    }

    @Test
    public void testCreateFan() {
        Regulator fan = factory.createFan("fan");
        assertEquals("fan", fan.getName());
    }

    @Test
    public void testCreateHeatSensor() {
        AbstractSensor<Double> sensor = factory.createHeatSensor("heat sensor");
        assertEquals("heat sensor", sensor.getName());
    }

    @Test
    public void testCreateMotionSensor() {
        AbstractSensor<Boolean> sensor = factory.createMotionSensor("motion sensor");
        assertEquals("motion sensor", sensor.getName());
    }
    
    @Test
    public void testCreateGroup() {
        DomoticDevice group = factory.createGroup("standard group");
        assertEquals("standard group", group.getName());
    }
}