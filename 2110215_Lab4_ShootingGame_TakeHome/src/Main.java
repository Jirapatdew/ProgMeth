/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */
import ui.GameManager;
import lib.IGameLogic;
import lib.MainLogic;

public class Main {

	public static void main(String[] args){
		IGameLogic logic = new MainLogic();
		GameManager.runGame(logic);
	}
}
