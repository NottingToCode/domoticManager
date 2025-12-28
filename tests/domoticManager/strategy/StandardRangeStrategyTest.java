package domoticManager.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domoticManager.strategy.StandardRangeStrategy;

public class StandardRangeStrategyTest {

	@Test
	public void testGetMin() {
		StandardRangeStrategy strategy = new StandardRangeStrategy(5, 50);
		assertEquals(5, strategy.getMin());
	}

	@Test
	public void testGetMax() {
		StandardRangeStrategy strategy = new StandardRangeStrategy(5, 50);
		assertEquals(50, strategy.getMax());
	}

	@Test
	public void testApplyInsideRange() {
		StandardRangeStrategy strategy = new StandardRangeStrategy(0, 10);
		assertEquals(5, strategy.apply(5));
	}

	@Test
	public void testApplyBelowMin() {
		StandardRangeStrategy strategy = new StandardRangeStrategy(0, 10);
		assertEquals(0, strategy.apply(-5));
	}

	@Test
	public void testApplyAboveMax() {
		StandardRangeStrategy strategy = new StandardRangeStrategy(0, 10);
		assertEquals(10, strategy.apply(15));
	}
}