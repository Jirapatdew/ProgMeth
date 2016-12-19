package logic;

public abstract class ShootableObject extends TargetObject {

	protected int reward;
	protected int life;
	
	public ShootableObject(int radius, int movingDuration,int z,int reward) {
		super(radius, movingDuration, z);
		this.reward = reward;
	}
	
	public void setLife(int life){
		if(life < 0) life = 0;
		if(life == 0) isDestroyed = true;
		this.life = life;
	}
	
	public void hit(PlayerStatus player){
		int attack = player.getCurrentGun().getAttack();
		setLife(life - attack);
		if(isDestroyed) player.increaseScore(reward);
	}
}
