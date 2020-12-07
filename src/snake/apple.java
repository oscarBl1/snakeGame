package snake;

import java.awt.Color;
import java.awt.Graphics;

public class apple {

    private int xCoord, yCoord, WIDTH, HEIGHT;

    public apple(int xCoord, int yCoord, int tileSize) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        WIDTH = tileSize;
        HEIGHT = tileSize;
    }

    public void tick() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xCoord * WIDTH, yCoord * HEIGHT, WIDTH, HEIGHT);
    }
    public int getxCoord(){
        return xCoord;
    }
    public void setxCoords(int xCoord){
        this.xCoord = xCoord;
    }
    public int getyCoord(){
        return yCoord;
    }
    public void setyCoords(int yCoord){
        this.yCoord = yCoord;
    }
}
