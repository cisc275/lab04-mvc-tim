package cisc275;
/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Timothy Mazzarelli

public class View extends JPanel {
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	final int dir = 8;
	final int frameCount = 10;
	int picNum = 0;
	int xloc = 0;
	int yloc = 0;
	BufferedImage[] img;
	BufferedImage[][] pics;
	Direction direction = Direction.SOUTHEAST;
	
	
	public int getWidth() {
		return frameWidth;
	}
	public int getHeight() {
		return frameHeight;
	}
	
	public int getImageHeight() {
		return imgHeight;
	}
	public int getImageWidth() {
		return imgWidth;
	}
	
	private BufferedImage createImage(String directionName){
	    	BufferedImage bufferedImage;
	    	try {
	    		bufferedImage = ImageIO.read(new File("C:/images/orc/orc_forward_" + directionName + ".png"));
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    }
	
	public View() {
    			img = new BufferedImage[dir];
    		for (int i = 0; i < dir; i++) {
    			img[i] = createImage(Direction.values()[i].getName());
    		}
    		
    		pics = new BufferedImage[dir][frameCount];
    		for (int i = 0; i < dir; i++) {
    			for (int j = 0; j < frameCount; j++) {
    				pics[i][j] = img[i].getSubimage(imgWidth * j, 0, imgWidth, imgHeight);
    			}
    		}
    		
    		JFrame frame = new JFrame();
    		frame.getContentPane().add(this);
    		frame.setBackground(Color.gray);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setSize(frameWidth, frameHeight);
       		frame.setResizable(false);
       		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		picNum = (picNum + 1) % frameCount;
		g.drawImage(pics[direction.ordinal()][picNum], xloc, yloc, Color.gray, this);
	}
	
	public void update(int xloc, int yloc, Direction direction) {
			this.xloc = xloc;
			this.yloc = yloc;
			this.direction = direction;
			repaint();
		try {
			Thread.sleep(100);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Controller game = new Controller();
		game.start();
	}
	
}