package logic;

import lib.AudioUtility;

public abstract class CollectibleObject extends TargetObject {
	
	protected int requiredGrabbingTime;
	protected int grabbingTimeCount;
	
	public CollectibleObject(int radius, int movingDuration, int z, int requiredGrabbingTime) {
		super(radius, movingDuration, z);
		this.requiredGrabbingTime = requiredGrabbingTime;
	}
	
	public void ungrab(){
		grabbingTimeCount = 0;
	}

	public void grab(PlayerStatus player){
		if(isDestroyed) return;
		if(grabbingTimeCount == requiredGrabbingTime){
			AudioUtility.playSound("collect");
			collect(player);
			isDestroyed = true;
			return;
		}
		grabbingTimeCount++;
	}
	
	public abstract void collect(PlayerStatus player);
}
