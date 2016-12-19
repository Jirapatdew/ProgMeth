package test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

import render.DrawingUtility;
import render.GameAnimation;

public class TestGameAnimation {

	@Test
	public void testConstructor() {
		GameAnimation anim = new GameAnimation(null, 7, 1);
		assertEquals(anim.getFrameCount(), 7);
		assertEquals(anim.getFrameDelay(), 1);
		assertEquals(anim.getCurrentFrame(), 0);
		assertEquals(anim.getFrameDelayCount(), 0);
		assertNull(anim.getImage());
		assertEquals(anim.getFrameWidth(), 0);
		assertEquals(anim.getFrameHeight(), 0);
		assertEquals(anim.getX(), 0);
		assertEquals(anim.getY(), 0);
		
		anim = new GameAnimation(DrawingUtility.getShootanim(), 7, 1);
		assertEquals(anim.getFrameCount(), 7);
		assertEquals(anim.getFrameDelay(), 1);
		assertEquals(anim.getCurrentFrame(), 0);
		assertEquals(anim.getFrameDelayCount(), 0);
		assertSame(anim.getImage(), DrawingUtility.getShootanim());
		assertEquals(anim.getFrameWidth(), 100);
		assertEquals(anim.getFrameHeight(), 100);
		assertEquals(anim.getX(), 0);
		assertEquals(anim.getY(), 0);
	}

	@Test
	public void testUpdateAnimation() {
		GameAnimation anim = new GameAnimation(DrawingUtility.getShootanim(), 7, 1);
		anim.setPlaying(true);
		anim.updateAnimation();
		assertEquals(anim.getFrameDelayCount(), 1);
		assertEquals(anim.getCurrentFrame(), 1);
		
		anim.setFrameDelayCount(1);
		anim.updateAnimation();
		assertEquals(anim.getFrameDelayCount(), 0);
		assertEquals(anim.getCurrentFrame(), 1);
	}
}
