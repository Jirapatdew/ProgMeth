package model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Field {
	private int[][] map = new int[6][6];
	private CopyOnWriteArrayList<Entity> entities =  new CopyOnWriteArrayList<Entity>();

	public Field() {
		map[2][1] = -2;
		map[1][4] = map[4][2] = -1;
	}
	
	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;
	}
	public boolean outOfField(int x,int y) {
		if(x < 0 || x > 5 || y < 0 || y > 5) return true;
		return false;
		
	}
	public int getTerrainAt(int x,int y) {
		if(outOfField(x, y)) return -3;
		return map[x][y];
		
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public void updateFieldState() {
		//Step1: clear all destroyed entities
		for(Entity it : entities) {
			if(it.isDestroyed) {
				entities.remove(it);
			}
		}
		
		//Step2: update action of active entities
		for(Entity ent : entities) {
			ent.update();
		}
		//Step3: detect a bullet collision
		for(Entity ent : entities) {
			if(ent instanceof ExtraBullet) ((ExtraBullet)ent).hit();
			else if(ent instanceof Bullet) ((Bullet)ent).hit();
		}
	}
}
