package model;

public class ExtraBullet extends Bullet {
	
	public ExtraBullet(Field field, int x, int y, int direction, int movingDelay, int power, Tank shooter) {
		super(field, x, y, direction, movingDelay, power, shooter);
	}

	public void hit() {
		for(int i = 0; i < field.getEntities().size(); i++) {
			Entity ent = field.getEntities().get(i);
			if(this.isSamePosition(ent)) {
				if(ent instanceof Tank) {
					Tank tank = (Tank)ent;
					if(this.shooter == tank) continue;
					tank.decreaseLife(power);
					this.isDestroyed = true;
				}
				else if(ent instanceof Bullet) {
					Bullet bull = (Bullet)ent;
					if(this.shooter == bull.shooter) continue;
					this.isDestroyed = true;
					bull.isDestroyed = true;
				}
			}
		}
	}
}
