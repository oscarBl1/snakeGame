
package snake;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
    
    private int xCoord, yCoord, WIDTH, HEIGHT;
    public BodyPart(int xCoord, int yCoord, int tileSize){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        WIDTH = tileSize;
        HEIGHT = tileSize;
    }
    public void tick(){
        
    }
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(xCoord*WIDTH, yCoord*HEIGHT, WIDTH, HEIGHT);
    }
    
    public int getxCoord(){
        return xCoord;
    }
    public void setxCoord(int xCoord){
       this.xCoord = xCoord;
    }
    public int getyCoord(){
        return yCoord;
    }
    public void setyCoord(int yCoord){
        this.yCoord = yCoord;
    }
}
