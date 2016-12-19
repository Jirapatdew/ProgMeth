package test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logic.WeightItem;

import org.junit.Test;

public class WeightItemTest {

	@Test
	public void testCost() {
		//fail("Not yet implemented");
		
		WeightItem item = new WeightItem("Soup", 5.25);
		item.setWeight(3.00);
		assertEquals(15.75,item.cost(),0.01);
	}

	@Test
	public void testScale() {
		//fail("Not yet implemented");
		
		WeightItem item = new WeightItem("Soup", 5.25);
		double weight;
		for (int i = 0 ; i < 10000; i++)
		{
			weight = item.scale();
			assertTrue(weight >= 0.01 && weight <= 4);
		}
	}

	
	@Test
	public void testToString() {
		//fail("Not yet implemented");
		
		WeightItem item = new WeightItem("Soup", 5.12);
		item.setWeight(5.00);
		String pattern = "^WeightItem\\s+:\\s+Soup\\s+([+-]?(\\d+\\.)\\d+)\\s+\\$([+-]?(\\d+\\.)\\d+)\\s+\\$([+-]?(\\d+\\.)\\d+)";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(item.toString());
		assertTrue(matcher.find());
		assertEquals(5f, Float.parseFloat(matcher.group(1)), 0.0001f);
		assertEquals(5.12f, Float.parseFloat(matcher.group(3)), 0.0001f);
		assertEquals(25.60f, Float.parseFloat(matcher.group(5)), 0.0001f);
	}

}
