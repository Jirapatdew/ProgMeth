package test;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

import render.InputUtility;

public class TestInputUtility {

	@Test
	public void testKeyPressed() {
		boolean keyPressed;
		InputUtility.setKeyPressed(KeyEvent.VK_SPACE, true);
		keyPressed = InputUtility.getKeyPressed(KeyEvent.VK_SPACE);
		assertTrue(keyPressed);
		keyPressed = InputUtility.getKeyPressed(KeyEvent.VK_ENTER);
		assertFalse(keyPressed);

		InputUtility.setKeyPressed(KeyEvent.VK_SPACE, false);
		keyPressed = InputUtility.getKeyPressed(KeyEvent.VK_SPACE);
		assertFalse(keyPressed);
		keyPressed = InputUtility.getKeyPressed(KeyEvent.VK_ENTER);
		assertFalse(keyPressed);

		// check keyPressed lower bound
		InputUtility.setKeyPressed(-1, true);
		keyPressed = InputUtility.getKeyPressed(-1);
		assertFalse(keyPressed);

		// check keyPressed upper bound
		InputUtility.setKeyPressed(256, true);
		keyPressed = InputUtility.getKeyPressed(256);
		assertFalse(keyPressed);
	}

	@Test
	public void testKeyTriggered() {
		boolean keyTriggered;
		InputUtility.setKeyTriggered(KeyEvent.VK_SPACE, true);
		keyTriggered = InputUtility.getKeyTriggered(KeyEvent.VK_SPACE);
		assertTrue(keyTriggered);
		keyTriggered = InputUtility.getKeyTriggered(KeyEvent.VK_ENTER);
		assertFalse(keyTriggered);

		InputUtility.setKeyTriggered(KeyEvent.VK_SPACE, false);
		keyTriggered = InputUtility.getKeyTriggered(KeyEvent.VK_SPACE);
		assertFalse(keyTriggered);
		keyTriggered = InputUtility.getKeyTriggered(KeyEvent.VK_ENTER);
		assertFalse(keyTriggered);

		// check keyTriggered lower bound
		InputUtility.setKeyTriggered(-1, true);
		keyTriggered = InputUtility.getKeyTriggered(-1);
		assertFalse(keyTriggered);

		// check keyTriggered upper bound
		InputUtility.setKeyTriggered(256, true);
		keyTriggered = InputUtility.getKeyTriggered(256);
		assertFalse(keyTriggered);
	}

	@Test
	public void testPostUpdate() {
		InputUtility.setKeyTriggered(KeyEvent.VK_SPACE, true);
		InputUtility.setKeyTriggered(KeyEvent.VK_ENTER, true);
		InputUtility.setMouseLeftTriggered(true);
		InputUtility.setMouseRightTriggered(true);
		InputUtility.postUpdate();

		assertFalse(InputUtility.isMouseLeftClicked());
		assertFalse(InputUtility.isMouseRightClicked());

		for (int key = 0; key < 256; key++)
			assertFalse(InputUtility.getKeyTriggered(key));
	}
}
