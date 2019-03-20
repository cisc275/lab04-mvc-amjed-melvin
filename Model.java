
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
	

	int x;
	int y;
	int dir = 3;
    int xChg = 1;
    int yChg = 1;
	static int picNum = 0;
	final int xIncr = 8;
    final int yIncr = 2;
	int orcWidth = 165;
	int orcHeight = 165;
    int frameWidth = 500;
    int frameHeight = 300;
	
	public Model(int frameWidth,int frameHeight, int orcWidth, int orcHeight) {
		this.orcWidth = orcWidth;
		this.orcHeight = orcHeight;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		
	}
	
	public static void main(String[] args) {
		System.out.println("MAIN");
		Controller ctrl = new Controller();
		ctrl.start();
	}
	
	public void updateLocationAndDirection() {
		//System.out.println("model: updateLocAndDir");
		picNum = (picNum + 1) % View.getFrameCount();
        if(x > (frameWidth - View.getImageWidth()) || x < 0) {
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
        if(y > (frameHeight - View.getImageHeight()) || y < 0) {

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
        x += xChg*xIncr;
        y += yChg*yIncr;
        //View.paint();
       // imageDraw(g,dir,xChg,yChg);
        System.out.println(x);
        System.out.println(y);
        System.out.println("Dir " + dir);
	}
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public int getDirect() { return dir; }
	
	public static int getPicNum() { return picNum; }


	
}