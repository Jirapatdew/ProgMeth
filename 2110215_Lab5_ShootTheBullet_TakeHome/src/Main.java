/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 18 Nov 2015
 * Lab5 part2 (2/2014) in 2110215 Prog Meth
 */

import render.GameManager;
import lib.logic.MainLogic;


public class Main {

	public static void main(String[] args){
		MainLogic logic = new MainLogic();
		GameManager.runGame(logic);
	}
}
