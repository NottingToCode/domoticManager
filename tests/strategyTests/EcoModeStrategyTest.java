package strategyTests;

import static org.junit.Assert.*;
import org.junit.Test;
import strategy.EcoModeStrategy;

public class EcoModeStrategyTest {

    @Test
    public void testApplyRespectsEcoLimit() {
        EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);

        int result = ecoStrategy.apply(50);

        assertEquals(20, result);
        
        result = ecoStrategy.apply(15);
        
        assertEquals(15, result);
    }

    @Test
    public void testAppl() {
        EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);

        int result = ecoStrategy.apply(15);

        assertEquals(15, result);
        
    }

    @Test
    public void testGetMaxReturnsPhysicalMax() {
        EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);
        assertEquals(100, ecoStrategy.getMax());
    }
    
    
    

}