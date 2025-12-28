package domoticManager;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RadiatorTest {

    private DomoticDeviceFactory factory;
    private Radiator radiator;

    @Before
    public void setup(){
        factory = new DomoticDeviceFactory();
        radiator = (Radiator)factory.createRadiator("radiatore1");
    }

    @Test
    public void testRadiatorName() {
        assertEquals("radiatore1", radiator.getName());
    }

    @Test
    public void testIsOffInitially() {
        assertFalse(radiator.isOn());
    }

    @Test
    public void testMaxValue() {
        assertEquals(100, radiator.getMaxValue());
    }

    @Test
    public void testTurnOn() {
        radiator.turnOn();
        assertTrue(radiator.isOn());
    }

    @Test
    public void testTurnOff() {
        radiator.turnOff();
        assertFalse(radiator.isOn());
    }

    @Test
    public void testGetInitalHeatLevel() {
        assertEquals(0, radiator.getHeatValue());
    }

    @Test
    public void testSetHeatLevel() {
        radiator.setHeatValue(80);
        assertEquals(80, radiator.getHeatValue());
    }

    @Test
    public void testSetHeatLevelIfNegative() {
        radiator.setHeatValue(-80);
        assertEquals(0, radiator.getHeatValue());
    }

    @Test
    public void testSetHeatLevelIfOver100() {
        radiator.setHeatValue(110);
        assertEquals(100, radiator.getHeatValue());
    }
}