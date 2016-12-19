package logic;

import java.awt.Graphics2D;

import lib.AudioUtility;
import lib.DrawingUtility;

public class SpecialGun extends Gun {

	protected int bulletQuantity;
	protected int maxBullet;
	
	public SpecialGun(int bulletQuantity, int maxBullet, int attack) {
		super(attack);
		if(bulletQuantity < 0) bulletQuantity = 0;
		if(bulletQuantity > maxBullet) bulletQuantity = maxBullet;
		this.bulletQuantity = bulletQuantity;
		this.maxBullet = maxBullet;
	}

	public int getBulletQuantity() {
		return bulletQuantity;
	}

	public void setBulletQuantity(int bulletQuantity) {
		if(bulletQuantity < 0) bulletQuantity = 0;
		if(bulletQuantity > maxBullet) bulletQuantity = maxBullet;
		this.bulletQuantity = bulletQuantity;
	}

	@Override
	public boolean canShoot(){
		if(bulletQuantity > 0) return true;
		return false;
	}
	
	@Override
	public void shoot(){
		AudioUtility.playSound("shoot");
		bulletQuantity--;
	}
	
	@Override
	public void render(Graphics2D g2) {
		DrawingUtility.drawIconGun(g2, bulletQuantity, maxBullet, false);
	}
}
