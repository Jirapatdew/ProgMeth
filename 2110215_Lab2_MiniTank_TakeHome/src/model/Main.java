package model;

import java.awt.Color;

public class Main {
	
	public static void main(String[] args) {
		Field field = new Field();
		new Tank(field,1,1,2,3,3,0,5,Color.blue);
		new Tank(field,3,4,0,3,3,1,5,Color.red);
		utility.GameScreen.createGameScreen(field);
	}
}
