package test;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Bullet;
import model.ExtraBullet;
import model.Entity;
import model.Field;
import model.Tank;

import org.junit.Before;
import org.junit.Test;

public class TestBullet {

	private Field field = new Field();
	private java.lang.reflect.Field f = null;

	@Before
	public void setUp() {
		try {
			f = Entity.class.getDeclaredField("isDestroyedInNextState");
			f.setAccessible(true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			System.out.println("Security Ex");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			System.out.println("No field");
		}
	}

	@Test
	public void testCalculateNextState() {
		Tank t = new Tank(field, 0, 0, Entity.EAST, 3, 3, 0, 5, Color.BLUE);
		Bullet b = new Bullet(field, 0, 0, Entity.WEST, 1, 1, t);
		assertEquals(b.getNextX(), 0);
		assertEquals(b.getNextY(), 0);
		try {
			assertTrue(f.getBoolean(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Exception 1");
		}

		b = new Bullet(field, 2, 0, Entity.WEST, 1, 1, t);
		assertEquals(b.getNextX(), 1);
		assertEquals(b.getNextY(), 0);

		b = new Bullet(field, 1, 3, Entity.SOUTH, 1, 1, t);
		assertEquals(b.getNextX(), 1);
		assertEquals(b.getNextY(), 4);

		b = new Bullet(field, 2, 2, Entity.NORTH, 1, 1, t);
		assertEquals(b.getNextX(), 2);
		assertEquals(b.getNextY(), 2);
		try {
			assertTrue(f.getBoolean(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Exception 2");
		}
	}

	@Test
	public void testUpdate() {
		Tank t = new Tank(field, 0, 0, Entity.EAST, 3, 3, 0, 5, Color.BLUE);
		Bullet b = new Bullet(field, 1, 0, Entity.WEST, 1, 1, t);
		b.update();
		assertEquals(1, b.getX());
		assertEquals(0, b.getY());
		b.update();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
	}

	@Test
	public void testHit() {
		Tank t = new Tank(field,1,1,Entity.EAST,3,3,0,5,Color.BLUE);
		Tank t2 = new Tank(field,1,2,Entity.EAST,3,3,0,5,Color.BLUE);
		Bullet bullet = new Bullet(field,1,0,Entity.SOUTH,0,1,t);
		//Cannot hit shooter
		bullet.update();
		bullet.hit();
		assertFalse(bullet.isDestroyed());
		//Hit tank2
		bullet.update();
		bullet.hit();
		assertTrue(bullet.isDestroyed());
		assertEquals(4,t2.getLife());
		assertEquals(false, t2.isDestroyed());
		
		field.getEntities().remove(bullet);
		
		// When the bullet hit the tank, 
		// the tank's life should be decreased by an amount of the bullet's power
		bullet = new Bullet(field,1,2,Entity.SOUTH,0,3,t);
		bullet.hit();
		assertEquals(1 , t2.getLife());
		assertEquals(true, bullet.isDestroyed());
		Bullet extraBullet = new ExtraBullet(field,1,1,Entity.SOUTH,0,4,t2);
		extraBullet.hit();
		assertEquals(1, t.getLife());
		assertEquals(true, extraBullet.isDestroyed());
		
		//ExtraBullet can hit bullet
		extraBullet = new ExtraBullet(field,0,0,Entity.SOUTH,0,1,t);
		Bullet bullet2 = new Bullet(field,0,0,Entity.NORTH,0,1,t2);
		extraBullet.hit();
		assertTrue(extraBullet.isDestroyed());
		assertTrue(bullet2.isDestroyed());
		
		field.getEntities().remove(extraBullet);
		field.getEntities().remove(bullet2);
		
		//But not the bullet from the same shooter
		extraBullet = new ExtraBullet(field,0,0,Entity.SOUTH,0,1,t);
		bullet2 = new Bullet(field,0,0,Entity.NORTH,0,1,t);
		extraBullet.hit();
		assertFalse(extraBullet.isDestroyed());
		assertFalse(bullet2.isDestroyed());
		
		// When the bullet hit the tank 
		// and the tank's life is decreased to the number less than or equal to 0, 
		// the tank's life should be 0 and it should be destroyed
		bullet = new Bullet(field,1,2,Entity.SOUTH,0,2,t);
		bullet.hit();
		assertEquals(0 , t2.getLife());
		assertEquals(true, bullet.isDestroyed());
		assertEquals(true, t2.isDestroyed());
		
		extraBullet = new ExtraBullet(field,1,1,Entity.SOUTH,0,1,t2);
		extraBullet.hit();
		assertEquals(0, t.getLife());
		assertEquals(true, extraBullet.isDestroyed());
		assertEquals(true, t.isDestroyed());
	}
}
