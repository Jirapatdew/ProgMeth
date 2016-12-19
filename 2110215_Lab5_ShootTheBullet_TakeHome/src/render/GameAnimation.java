/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 18 Nov 2015
 * Lab5 part2 (2/2014) in 2110215 Prog Meth
 */
package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

import lib.IRenderableObject;

public class GameAnimation implements IRenderableObject {

	private BufferedImage image = null;
	private int frameCount,frameDelay;
	private int currentFrame,frameDelayCount;
	private int x,y,frameWidth,frameHeight;
	private boolean visible = false, playing = false;
	
	public GameAnimation(BufferedImage image,int frameCount,int frameDelay){
		this.frameCount = frameCount;
		this.frameDelay = frameDelay;
		currentFrame = 0;
		frameDelayCount = 0;
		x = 0;
		y = 0;
		try {
			this.image = image;
			frameWidth = image.getWidth() / frameCount;
			frameHeight = image.getHeight();
		} catch(NullPointerException e){
			frameWidth = 0;
			frameHeight = 0;
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public int getFrameDelay() {
		return frameDelay;
	}

	public void setFrameDelay(int frameDelay) {
		this.frameDelay = frameDelay;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public int getFrameDelayCount() {
		return frameDelayCount;
	}

	public void setFrameDelayCount(int frameDelayCount) {
		this.frameDelayCount = frameDelayCount;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	protected void topLeftAnimationAt(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	protected void centerAnimationAt(int x,int y){
		this.x = x-frameWidth/2;
		this.y = y-frameHeight/2;
	}
	
	public void play(){
		currentFrame = 0;
		playing = true;
		visible = true;
	}
	
	public void stop(){
		currentFrame = 0;
		playing = false;
		visible = false;
	}
	
	public void updateAnimation(){
		if(playing){
			if(frameDelayCount > 0) {
				frameDelayCount--;
				return;
			}
			else {
				frameDelayCount = frameDelay;
				currentFrame++;
				if(currentFrame == frameCount) stop();
			}
		}
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void render(Graphics2D g2) {
		if(visible && image != null) {
			g2.drawImage(image.getSubimage(frameWidth*(currentFrame), 0, frameWidth, frameHeight), null, x, y);
		}
	}

}
