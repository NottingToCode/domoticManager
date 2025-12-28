package domoticManager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domoticManager.strategy.EcoModeStrategy;

public class EcoModeStrategyTest {

	@Test
	public void testApplyRespectsEcoLimit() {
		EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);

		assertEquals(20, ecoStrategy.apply(50));
	}

	@Test
	public void testApplyWorksNormalBelowLimit() {
		EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);

		assertEquals(15, ecoStrategy.apply(15));
	}

	@Test
	public void testGetMaxReturnsPhysicalMax() {
		EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);

		assertEquals(100, ecoStrategy.getMax());
	}

	@Test
	public void testGetMin() {
		EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);
		assertEquals(0, ecoStrategy.getMin());
	}

	@Test
	public void testGetEcoLimit() {
		EcoModeStrategy ecoStrategy = new EcoModeStrategy(0, 100, 20);
		assertEquals(20, ecoStrategy.getEcoLimit());
	}
}