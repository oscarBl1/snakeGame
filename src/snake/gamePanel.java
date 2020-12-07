
package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


public class gamePanel extends JPanel implements Runnable, KeyListener{
    
    private static final long serialVersionUID = 1L;
    public static final int width = 500, height = 500;
    private Thread thread;
    private boolean running;
    private BodyPart b;
    private ArrayList<BodyPart> snake;
    private int xCoord = 10, yCoord = 10, size = 10;
    private int ticks = 0;
    private boolean right = true, left = false, up = false, down = false;
    private apple apple;
    private ArrayList<apple> apples;
    private Random r;
    
    public gamePanel(){
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        addKeyListener(this);
        snake = new ArrayList<BodyPart>();
        apples = new ArrayList<apple>();
        r = new Random();
        start();
    }
    
    
    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void tick(){
        if(snake.size()==0){
            b = new BodyPart(xCoord, yCoord, 10);
            snake.add(b);
        }
        ticks++;
        if(ticks > 250000){
            if(right) xCoord++;
            if(left) xCoord--;
            if(up) yCoord--;
            if(down) yCoord++;
            
            ticks = 0;
            b = new BodyPart(xCoord, yCoord, 10);
            snake.add(b);
            
            if(snake.size() > size){
                snake.remove(0);
            }
        }
        if(apples.size() == 0){
            int xCoord = r.nextInt(49);
            int yCoord = r.nextInt(49);
            
            apple = new apple(xCoord, yCoord, 10);
            apples.add(apple);
        }
        int score = 0;
        for(int i = 0; i < apples.size(); i++){
            if(xCoord == apples.get(i).getxCoord() && yCoord == apples.get(i).getyCoord()){
                score++;
                System.out.println("Current score: " + score);
                size+=2;
                apples.remove(i);
                i++;
            }
        }
        for(int i = 0; i < snake.size(); i++){
            if(xCoord == snake.get(i).getxCoord() && yCoord == snake.get(i).getyCoord()){
                if(i != snake.size()-1){
                    System.out.println("Game Over");
                    stop();
                }
            }
        }
        
        if(xCoord < 0 || xCoord > 49 || yCoord < 0 || yCoord > 49){
            System.out.println("Game Over");
            stop();
        }
            
    }
    public void paint(Graphics g){
        g.clearRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        
        for(int i = 0; i < width/10; i++){
            g.drawLine(i*10, 0, i*10, height);
        }
        for(int i = 0; i < height/10; i++){
            g.drawLine(0, i*10, height, i*10);
        }
        for(int i = 0; i < snake.size(); i++){
            snake.get(i).draw(g);
        }
        
        for(int i = 0; i < apples.size(); i++){
            apples.get(i).draw(g);
        }
    }

    @Override
    public void run() {
        while(running){
            tick();
            repaint();
        }
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !left){
            right = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_LEFT && !right){
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_UP && !down){
            up = true;
            left = false;
            right = false;
        }
        if(key == KeyEvent.VK_DOWN && !up){
            down = true;
            left = false;
            right = false;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    
}
