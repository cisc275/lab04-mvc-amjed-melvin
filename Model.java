import java.awt.Graphics;

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
	int imageWidth;
	int imageHeight;
	View view;
	
	Model(int width, int height, int imageWidth, int imageHeight) {
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	
    public void paint(Graphics g) {
        picNum = (picNum + 1) % frameCount;
        if(xloc > (frameWidth - imgWidth) || xloc < 0) {
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
        if(yloc > (frameHeight - getHeight()) || yloc < 0) {

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
        view.imageDraw(g,dir,xChg,yChg);
           
        // TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
        //Be sure that animation picture direction matches what is happening on screen.
    }
	//TODO
	public int getX() {return 0;}
	//TODO
	public int getY() {return 0;}
	//TODO
	int getDirect(){return 0;}
	//TODO
	void updateLocationAndDirection() {}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	
}