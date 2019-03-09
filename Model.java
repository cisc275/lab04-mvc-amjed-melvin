import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

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
    int xChg = 1;
    int yChg = 1;
	int dir = 3;
	View view;
	
	Model(int width,int height,int imgWidth,int imgHeight) {
		this.width = width;
		this.height = height;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}
	
	public void updateLocationAndDirection() {
		if(xloc > (width - imgWidth) || xloc < 0) {
        	switch(dir) {
	        	case 1:
	        		dir = 7;
	        		break;
	        	case 3:
	        		dir = 5;
	        		break;
	        	case 5:
	        		dir = 3;
	        		break;
	        	case 7:
	        		dir = 1;
	        		break;
        	}
        	xChg = -1*xChg;
        	
        }
        if(yloc > (height - imgHeight) || yloc < 0) {

        	yChg = -1*yChg;
        	switch(dir) {
        		case 1:
        			dir = 3;
        			break;
        		case 3:
        			dir = 1;
        			break;
        		case 5:
        			dir = 7;
        			break;
        		case 7:
        			dir = 5;
        			break;
        	}
        }
	}
	
	public void imageDraw(Graphics g,int dir,int xNeg,int yNeg, int xIncr, int yIncr) {
    	g.drawImage(view.getPics()[view.getPicNum()][dir], xloc+=xNeg*xIncr, yloc+=yNeg*yIncr, Color.blue, (ImageObserver) this);
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
	
	public int getXChg() {
		return xChg;
	}
	
	public int getYChg() {
		return yChg;
	}
	
}