package logic;

import java.awt.Graphics2D;
import lib.AudioUtility;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Gun implements IRenderableObject {

	protected int attack;
	
	public Gun(int attack) {
		/* fill code */
		this.attack =  attack;
	}
	
	/* fill required getter & setter */
	
	public int getAttack() {
		return attack;
	}
	
	public boolean canShoot(){
		return true;
	}
	

	public void shoot(){
		AudioUtility.playSound("shoot");
	}

	/* fill code interface methods */
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		//It will not be used, so, returning any value is acceptable
		return 0;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		//It will not be used, so, returning any value is acceptable
		return false;
	}

	@Override
	public void render(Graphics2D g2) {
		// TODO Auto-generated method stub
		DrawingUtility.drawIconGun(g2, 0, 0, true);
	}

}
