package logic;

import java.awt.Graphics2D;
import java.util.List;
import lib.DrawingUtility;
import lib.RandomUtility;

public class SplitterTarget extends ShootableObject {

	private List<TargetObject> onScreenObject;
	
	public SplitterTarget(int radius, int movingDuration, int z,
			List<TargetObject> onScreenObject) {
		super(radius, movingDuration, z, 5);
		setLife(5);
		this.onScreenObject = onScreenObject;
	}
	
	@Override
	public void hit(PlayerStatus player){
		int attack = player.getCurrentGun().getAttack();
		setLife(life - attack);
		if(isDestroyed) {
			player.increaseScore(reward);
			int num = RandomUtility.random(3,6);
			for(int i = 0; i < num; i++) {
				onScreenObject.add(new SmallTarget(radius/2, movingDuration, z, x, y));
			}
		}
	}

	@Override
	public void render(Graphics2D g2) {
		DrawingUtility.drawShootableObject(g2, x, y, radius, "splitter", isPointerOver);
	}

}
