package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Resource {
	
	public static final Font standardFont  = new Font("Tahoma", Font.BOLD, 30);
	public static BufferedImage appleSprite;
	public static AudioClip coinSound;
	static {
		try {
			appleSprite = ImageIO.read(new File("src/res/Apple.png"));
			coinSound =  Applet.newAudioClip(new File("src/res/coin.wav").toURI().toURL());
		} catch (Exception e) {
			appleSprite = null;
			coinSound = null;
		}
	}
	public Resource() {
	}
	
}
