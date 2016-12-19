package test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logic.UnitItem;

import org.junit.Test;

public class UnitItemTest {

	@Test
	public void testCost() {
		//fail("Not yet implemented");
		
		UnitItem item = new UnitItem("Apple",2.0,3);
		assertEquals(6.00, item.cost(),0.01);
	}
	
	@Test
	public void testToString() {
		//fail("Not yet implemented");
		
		UnitItem item = new UnitItem("Apple",3.0,4);
		String pattern = "^UnitItem\\s+:\\s+Apple\\s+([+-]?\\d+)\\s+\\$([+-]?(\\d+\\.)\\d+)\\s+\\$([+-]?(\\d+\\.)\\d+)";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(item.toString());
		assertTrue(matcher.find());
		assertEquals(4, Integer.parseInt(matcher.group(1)));
		assertEquals(3f, Float.parseFloat(matcher.group(2)), 0.0001f);
		assertEquals(12f, Float.parseFloat(matcher.group(4)), 0.0001f);
	}

}
