
import java.awt.Graphics;
import javax.swing.JFrame;
import sun.applet.Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahtab
 */
public class GameFrame extends JFrame{
   GamePanel gamePanel;

    
    public GameFrame(String tankPlayer1,String tankPlayer2){
        gamePanel = new GamePanel(tankPlayer1,tankPlayer2);
        (new Thread(gamePanel)).start();
        setLayout(null);
        setTitle(tankPlayer1 +"     VS      " + tankPlayer2);
        setSize(1340,700);
        setLocation(0,0);
        setResizable(false);
       this.getContentPane().add(gamePanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
    }
    public static void main(String args[]){
        GameFrame gameframe = new GameFrame("","");
       // System.out.println("hhhhhhhs");

    }
    
}
