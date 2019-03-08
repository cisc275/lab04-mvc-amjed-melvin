import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/


public class View extends JPanel {
	
	final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165; 
    JFrame frame;
    Model model;
    int picNum = 0;
    final int frameCount = 10;

    public View(JFrame frame){
    	this.frame = frame;
    	BufferedImage[][] pics;
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
    
	public void update(int currX, int currY, int dir) {
		picNum = (picNum + 1) % frameCount;
		frame.repaint();
	}
	
	public void paint(Graphics g) {
		imageDraw(g,model.getDirect(),model.getXChg(),model.getYChg());
	}
	
	public void imageDraw(Graphics g,int dir,int xNeg,int yNeg) {
    	g.drawImage(pics[picNum][dir], xloc+=xNeg*xIncr, yloc+=yNeg*yIncr, Color.blue, this);
    }

	public int getWidth() {
		return frameWidth;
	}

	public int getHeight() {
		return frameHeight;
	}

	public static int getImageWidth() {
		return imgWidth;
	}

	public static int getImageHeight() {
		return imgHeight;
	}
	
	
}

//view.update(model.getX(), model.getY(), model.getDirect());
//}