import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {
	
	int width;
	int height;
	int imgWidth;
	int imgHeight;
	int xloc = 0;
	int yloc = 0;
	int dir = 3;
	
	Model(int width,int height,int imgWidth,int imgHeight) {
		this.width = width;
		this.height = height;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}
	
	public void updateLocationAndDirection() {
		//TODO
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getImgWidth() {
		return imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}

	public int getX() {
		return xloc;
	}

	public int getY() {
		return yloc;
	}

	public int getDirect() {
		return dir;
	}
	
	
	
}