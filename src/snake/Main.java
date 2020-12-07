
package snake;

import javax.swing.JFrame;


public class Main {

    public Main(){
        JFrame frame = new JFrame();
        gamePanel gamepanel = new gamePanel();
        
        frame.add(gamepanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.setResizable(false);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        new Main();
    }
    
}
