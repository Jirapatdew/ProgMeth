package logic;

import static org.junit.Assert.*;
import org.junit.*;

public class Tester {
	
	/* priority alert --- year > month > date */
	@Test
	public void testAddTask() {
	    assertEquals("Task is successfully added", DailyPlanner.addTask(25, 8, 2012));
	    assertEquals("Task is successfully added", DailyPlanner.addTask(26, 8, 2012));
	    assertEquals("Task is successfully added", DailyPlanner.addTask(27, 8, 2012));
	    assertEquals("Task is successfully added", DailyPlanner.addTask(2, 8, 20));
	    assertEquals("Task is successfully added", DailyPlanner.addTask(29, 2, 2000));//LeapYear
	}
	
	@Test
	public void testAddTask2() {
		assertEquals("Unable to add. There is already a task on that day.", DailyPlanner.addTask(25, 8, 2012));
	    assertEquals("Unable to add. There is already a task on that day.", DailyPlanner.addTask(26, 8, 2012));
	    assertEquals("Unable to add. There is already a task on that day.", DailyPlanner.addTask(27, 8, 2012));
	    assertEquals("Unable to add. There is already a task on that day.", DailyPlanner.addTask(2, 8, 20));
	    assertEquals("Unable to add. There is already a task on that day.", DailyPlanner.addTask(29, 2, 2000));
	}
	
	@Test
	public void testAddTask3() {
		assertEquals("Invalid Year. Unable to add", DailyPlanner.addTask(22, 7, -2000));
		assertEquals("Invalid Year. Unable to add", DailyPlanner.addTask(5, 12, 0));
		assertEquals("Invalid Year. Unable to add", DailyPlanner.addTask(55, 12, 0));
		assertEquals("Invalid Year. Unable to add", DailyPlanner.addTask(5, 120, -8));
	}
	
	@Test
	public void testAddTask4() {
		assertEquals("Invalid Month. Unable to add", DailyPlanner.addTask(22, 97, 2000));
		assertEquals("Invalid Month. Unable to add", DailyPlanner.addTask(5, 120, 170));
		assertEquals("Invalid Month. Unable to add", DailyPlanner.addTask(5, -102, 1990));
		assertEquals("Invalid Month. Unable to add", DailyPlanner.addTask(55, 0, 1960));
	}
	
	@Test
	public void testAddTask5() {
		assertEquals("Invalid Date. Unable to add", DailyPlanner.addTask(211, 7, 2000));
		assertEquals("Invalid Date. Unable to add", DailyPlanner.addTask(-5, 5, 170));
		assertEquals("Invalid Date. Unable to add", DailyPlanner.addTask(32, 12, 1990));
		assertEquals("Invalid Date. Unable to add", DailyPlanner.addTask(29, 2, 2015));//NotLeapYear
	}
}
