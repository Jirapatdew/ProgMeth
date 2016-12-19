package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Resource {
	
	public static final Font largeFont = new Font("Century Gothic", Font.PLAIN, 80);
	public static final Font mediumFont = new Font("Century Gothic", Font.PLAIN, 36);
	public static final Font standardFont = new Font("Century Gothic", Font.PLAIN, 30);
	public static final Font smallFont = new Font("Century Gothic", Font.PLAIN, 26);
	public static final Color iBlack = new Color(59, 64, 67);
	public static final Color iYellow = new Color(243, 156, 18);
	public static final Color iGreen = new Color(26, 188, 156);
	public static final Color iPink = new Color(251,97,105);
	
	private static BufferedImage getImage(String directory){
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			return ImageIO.read(loader.getResource(directory));
		} catch(Exception e) {
			return  null;
		}
	}
	private static AudioClip getSound(String directory){
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			return Applet.newAudioClip(loader.getResource(directory));
		} catch(Exception e) {
			return  null;
		}
	}
	public static InputStream getInput(String directory){
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			return  loader.getResourceAsStream(directory);
		} catch(Exception e) {
			return  null;
		}
	}
	
	public final static BufferedImage destructible_block=getImage("res/img/box.png");
	public final static BufferedImage movable_block=getImage("res/img/box2.png");
	public final static BufferedImage point_object=getImage("res/img/star.png");
	public final static BufferedImage player_img=getImage("res/img/player.png");
	
	public static final BufferedImage player = getImage("res/img/player.png");
	public static final BufferedImage star = getImage("res/img/star.png");
	public static final BufferedImage star2 = getImage("res/img/star2.png");
	public static final BufferedImage box = getImage("res/img/box.png");
	public static final BufferedImage box2 = getImage("res/img/box2.png");
	public static final BufferedImage heart = getImage("res/img/heart.png");
	
	public static AudioClip s_button = getSound("res/sound/s_button.wav");
	public static AudioClip s_star = getSound("res/sound/s_star.wav");
	public static AudioClip s_crash = getSound("res/sound/s_crash.wav");
	public static AudioClip s_hit = getSound("res/sound/s_hit.wav");
	public static AudioClip s_back = getSound("res/sound/s_back.wav");
	
	
	public static final BufferedImage[] rank = { null, getImage("res/img/trophies/rank1.png"),
			getImage("res/img/trophies/rank2.png"), getImage("res/img/trophies/rank3.png"),
			getImage("res/img/trophies/rank4.png"), getImage("res/img/trophies/rank5.png"),
			getImage("res/img/trophies/rank6.png"), getImage("res/img/trophies/rank7.png")};
	
	public static final BufferedImage logo = getImage("res/img/logo.png");
	public static final BufferedImage mainScreen = getImage("res/img/MainScreen.png");
	public static final BufferedImage mainScreen2 = getImage("res/img/MainScreen2.png");
	public static final BufferedImage howToPlay = getImage("res/img/howtoplay.png");
	
	public static final BufferedImage playButton = getImage("res/img/button/play.png");
	public static final BufferedImage statButton = getImage("res/img/button/stat.png");
	public static final BufferedImage soundButton = getImage("res/img/button/sound.png");
	public static final BufferedImage muteSoundButton = getImage("res/img/button/mute_sound.png");
	public static final BufferedImage controlButton = getImage("res/img/button/game_control.png");
	public static final BufferedImage infoButton = getImage("res/img/button/info.png");
	public static final BufferedImage backButton = getImage("res/img/button/back2.png");
	public static final BufferedImage menuButton = getImage("res/img/button/home.png");
	public static final BufferedImage flagButton = getImage("res/img/button/flag.png");
	public static final BufferedImage refreshButton = getImage("res/img/button/refresh.png");
	public static final BufferedImage likeButton = getImage("res/img/button/like.png");
	public static final BufferedImage likeButton2 = getImage("res/img/button/like2.png");
}
