package cisc275;
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

// Timothy Mazzarelli

public class Model {
	int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;
    Direction direction;
	int xloc = 0;
	int yloc = 0;
	int xIncr = 8;
	int yIncr = 2;
    
    
    public Model (int frameWidth,int frameHeight,int imgWidth,int imgHeight) {
    		this.frameWidth = frameWidth;
    		this.frameHeight = frameHeight;
    		this.imgWidth = imgWidth;
    		this.imgHeight = imgHeight;
    }
    
    public int getX() {
    		return xloc;
    }
    public int getY() {
    		return yloc;
    }
    public Direction getDirect() {
    		return direction;
    }
      
    public void updateLocationAndDirection() {	
    	if (xloc < 0 || xloc >= frameWidth - imgWidth) {
    		xIncr *= -1;
    	} 
    	
    	if (yloc < 0 || yloc >= frameHeight - imgHeight) {
    		yIncr *= -1;
    	}
  
    		xloc += xIncr;
    		yloc += yIncr;
    		
    		if (xIncr == 0 && yIncr < 0) {
        			direction = Direction.NORTH;
        			
        		}
        	if (xIncr > 0 && yIncr < 0) {
        			direction = Direction.NORTHEAST;
     
        		}
        	if (xIncr > 0 && yIncr == 0) {
        			direction = Direction.EAST;
        			
        	}
        	if (xIncr > 0 && yIncr > 0) {
        			direction = Direction.SOUTHEAST;
        			
        		}
       		if (xIncr == 0 && yIncr > 0) {
        			direction = Direction.SOUTH;
        			
        		}
       		if (xIncr < 0 && yIncr > 0) {
        			direction = Direction.SOUTHWEST;
        			
        		}
       		if (xIncr < 0 && yIncr == 0) {
        			direction = Direction.WEST;
        			
       		}
       		if (xIncr < 0 && yIncr < 0) {
        			direction = Direction.NORTHWEST;
       		}	   	
    }
}
