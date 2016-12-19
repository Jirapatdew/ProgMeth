package combo;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;


public class KeyCode {
	public static ArrayList<Integer> history = new ArrayList<Integer>();
	private static boolean[] keyPressed = new boolean[256];
	
	public static void main(String args[]) {
//			System.out.println(KeyEvent.VK_H+" "+KeyEvent.VK_E+" "+KeyEvent.VK_A+" "+KeyEvent.VK_R+" "+KeyEvent.VK_T);
//			System.out.println(KeyEvent.VK_T+" "+KeyEvent.VK_O);
			Frame f = new JFrame();
	        f.setSize(new Dimension(400, 400));
	        f.setVisible(true);
	        f.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					keyPressed[e.getKeyCode()] = false;
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if(keyPressed[e.getKeyCode()]) return;
					keyPressed[e.getKeyCode()] = true;
					history.add(e.getKeyCode());
					if(history.size()>10) history.remove(0);
					CheatCode();
					//System.out.println(checkCode());
				}
			});
	    }
	 static public void CheatCode(){
		 int[][] code = {{78,69,88,84,76,69,86,69,76}, //NEXTLEVEL
				 		 {65,68,68,83,67,79,82,69},	//ADDSCORE
				 		 {65,68,68,72,69,65,82,84},	//ADDHEART
				 		 {71,79,84,79,76,69,86,69,76}, //GOTOLEVEL
				 		 {83,69,84,83,67,79,82,69}}; //SETSCORE
		 for(int i = 0; i < code.length; i++){
			 boolean out = checkCode(code[i]);
			 for(int j= 0; j<code[i].length; j++){
				 System.out.printf("%c",code[i][j]);
				 
			 }
			 System.out.print(" : ");
			 System.out.println(out);
		 }
	 }
	 
	 static public boolean checkCode(int[] code) {
		 boolean cheat;
		 for(int i=0;i<=history.size()-code.length;i++) {
			 cheat = true;
			 for(int j=i;j<i+code.length;j++){
				if(history.get(j).intValue() != code[j-i]) {cheat=false;break;}
			 }
			 if(cheat){
				 System.out.println("Run Cheat");
				 history.clear();
				 return true;
			 }
		 }
		 return false;
		 
	 }
}


