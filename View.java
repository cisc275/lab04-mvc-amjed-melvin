import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/


public class View {
	int width;
	int height;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
	BufferedImage[][] pics;
	final int frameCount = 10;
	
	//TODO + change params
	public void update(int x, int y, Object direct) {
		// TODO Auto-generated method stub
		
	}
	
    public View(){
        String[] arrOfStr = {"forward_north", "forward_northeast", "forward_east", "forward_southeast",
                "forward_south", "forward_southwest", "forward_west", "forward_northwest"};
        BufferedImage[] img = createImage(arrOfStr);
        pics = new BufferedImage[10][arrOfStr.length];
        //System.out.println(img.length);
        int count = 0;
        for (BufferedImage curImg : img) {
            for(int i = 0; i < frameCount; i++) {
                pics[i][count] = curImg.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
            }
            count ++;
        }
 
    }   
	
	private BufferedImage[] createImage(String[] strArr){
        BufferedImage[] bufferedImage = new BufferedImage[strArr.length];
        String path = "orc_animation/orc_";
        int count = 0;
        for (String str : strArr) {
            try {
                
                bufferedImage[count] = ImageIO.read(new File(path.concat(str).concat(".png")));
                count ++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bufferedImage;
    }
	
    public void imageDraw(Graphics g,int dir,int xNeg,int yNeg) {
    	g.drawImage(pics[picNum][dir], xloc+=xNeg*xIncr, yloc+=yNeg*yIncr, Color.blue, this);
    }

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