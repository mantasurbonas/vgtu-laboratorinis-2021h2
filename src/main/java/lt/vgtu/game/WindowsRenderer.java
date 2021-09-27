package lt.vgtu.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.List;

import javax.imageio.ImageIO;

public class WindowsRenderer {

	private static final int IMG_INITIAL_X_OFFSET_PX = 50;
	private static final int IMG_SIZE_PX = 20;

	private List<Rocket> rockets;
	private Map map;
	
	private BufferedImage flameImg;
	private BufferedImage rocketImg;
	private BufferedImage asteroidImg;

	public WindowsRenderer(Map map, List<Rocket> rockets) throws Exception {
		this.map = map;
		this.rockets = rockets;
		
		rocketImg = ImageIO.read(new FileInputStream("starship.png"));
		flameImg = ImageIO.read(new FileInputStream("rocket-flame.png"));
		asteroidImg = ImageIO.read(new FileInputStream("asteroid.png"));
	}

	public void paint(Graphics g) {
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth(); x++) {
				int element = map.getElement(x, y);
				
				if (element == 1)
					drawAsteroid(g, x, y);
				else
				if (isRocketTail(x, y))
					drawRocketTail(g, x, y);
				else
				if (isRocketHead(x, y))
					drawRocketHead(g, x, y);
				else
					drawSpace(g, x, y);
			}
		}	
	}

	private int calculateImgPos(int rawPos) {
		return IMG_INITIAL_X_OFFSET_PX + rawPos * IMG_SIZE_PX;
	}

	private void drawSpace(Graphics g, int x, int y) {
	}

	private void drawRocketHead(Graphics g, int x, int y) {
		g.drawImage(rocketImg, calculateImgPos(x), calculateImgPos(y), IMG_SIZE_PX, IMG_SIZE_PX, null);
	}

	private void drawRocketTail(Graphics g, int x, int y) {
		g.drawImage(flameImg, calculateImgPos(x), calculateImgPos(y), IMG_SIZE_PX, IMG_SIZE_PX, null);
	}

	private void drawAsteroid(Graphics g, int x, int y) {
		g.drawImage(asteroidImg, calculateImgPos(x), calculateImgPos(y), IMG_SIZE_PX, IMG_SIZE_PX, null);
	}
	
	private boolean isRocketHead(int x, int y) {
		for (Rocket rocket: rockets)
			if (rocket.getXCoordinates()+1 ==x && rocket.getYCoordinates() == y)
				return true;
		
		return false;
	}

	private boolean isRocketTail(int x, int y) {
		for (Rocket rocket: rockets)
			if (rocket.getXCoordinates() ==x && rocket.getYCoordinates() == y)
				return true;
		
		return false;
	}
}