/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 18 Nov 2015
 * Lab5 part2 (2/2014) in 2110215 Prog Meth
 */
package render;

import java.applet.Applet;
import java.applet.AudioClip;

public class AudioUtility {
		
	private static AudioClip acShoot;
	private static AudioClip acCollect;
	static{
		ClassLoader loader = DrawingUtility.class.getClassLoader();
		acShoot = Applet.newAudioClip(loader.getResource("res/se/shoot.wav"));
		acCollect = Applet.newAudioClip(loader.getResource("res/se/collect.wav"));
	}
	
	public static void playSound(String identifier){
		if(identifier.equals("shoot")) acShoot.play();
		else acCollect.play();
	}
}
