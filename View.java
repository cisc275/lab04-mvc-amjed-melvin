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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165; 
    final int xIncr = 8;
    final int yIncr = 2;
    JFrame frame;
	static int currX;
	static int currY;
	static int x;
	static int y;
	static int direc;
	BufferedImage[][] pics;
    Model model;
    int picNum = 0;
    final int frameCount = 10;

    public View(JFrame frame){
    	model = new Model(frameWidth, frameHeight, imgWidth, imgHeight);
    	this.frame = frame;
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
    
    public View() {
		// TODO Auto-generated constructor stub
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
    
	public void update(int currX, int currY, int dir, Model model) {
		//System.out.println("im entering update");
		picNum = (picNum + 1) % frameCount;
		this.currX = currX + 8;
		x = x + xIncr*model.getXChg();
		y = y + yIncr*model.getYChg();
		this.currY = currY;
		this.direc = dir;
	}
	
	public void paint(Graphics g) {

		model.updateLocationAndDirection();
		//System.out.println("im in paint");
    	g.drawImage(pics[picNum][model.getDirect()], currX+=(model.getXChg())*xIncr, currY+=(model.getYChg())*yIncr, Color.gray, this);
    	//System.out.println("I'm leaving paint");
    	//model.imageDraw(g,model.getDirect(),model.getXChg(),model.getYChg(), xIncr, yIncr);
    	frame.repaint();
	}
	public int getCurrX() {
		return currX;
	}
	public int getCurrY() {
		return currY;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
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
	
	public BufferedImage[][] getPics() {
		return pics;
	}
	
	public int getPicNum() {
		return picNum;
	}
	
}

//view.update(model.getX(), model.getY(), model.getDirect());
//}