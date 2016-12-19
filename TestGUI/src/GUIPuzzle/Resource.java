package GUIPuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	protected static final Font largeFont = new Font("Century Gothic", Font.PLAIN, 80);
	protected static final Font mediumFont = new Font("Century Gothic", Font.PLAIN, 36);
	protected static final Font standardFont = new Font("Century Gothic", Font.PLAIN, 30);
	protected static final Font smallFont = new Font("Century Gothic", Font.PLAIN, 26);
	protected static final Color iBlack = new Color(59, 67, 67);
	protected static final Color iYellow = new Color(243, 156, 18);
	protected static final Color iGreen = new Color(26, 188, 156);

	private static BufferedImage getImage(String directory) {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			return ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			return null;
		}
	}

	protected static final BufferedImage player = getImage("res/player.png");
	protected static final BufferedImage star = getImage("res/star.png");
	protected static final BufferedImage star2 = getImage("res/star2.png");
	protected static final BufferedImage box = getImage("res/box.png");
	protected static final BufferedImage box2 = getImage("res/box2.png");
	protected static final BufferedImage heart = getImage("res/heart.png");

	protected static final BufferedImage[] rank = { null, getImage("res/trophies/rank1.png"),
			getImage("res/trophies/rank2.png"), getImage("res/trophies/rank3.png"),
			getImage("res/trophies/rank4.png"), getImage("res/trophies/rank5.png"),
			getImage("res/trophies/rank6.png"), getImage("res/trophies/rank7.png")};

	protected static final BufferedImage mainScreen = getImage("res/MainScreen.png");
	protected static final BufferedImage mainScreen2 = getImage("res/MainScreen2.png");

	protected static final BufferedImage playButton = getImage("res/button/play.png");
	protected static final BufferedImage statButton = getImage("res/button/stat.png");
	protected static final BufferedImage soundButton = getImage("res/button/sound.png");
	protected static final BufferedImage muteSoundButton = getImage("res/button/mute_sound.png");
	protected static final BufferedImage controlButton = getImage("res/button/game_control.png");
	protected static final BufferedImage infoButton = getImage("res/button/info.png");
	protected static final BufferedImage backButton = getImage("res/button/back2.png");
	protected static final BufferedImage menuButton = getImage("res/button/menu.png");
	protected static final BufferedImage refreshButton = getImage("res/button/refresh.png");
}
