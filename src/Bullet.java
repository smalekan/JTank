import java.awt.Graphics;
import javax.swing.ImageIcon;
import sun.java2d.pipe.DrawImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahtab
 */
public class Bullet implements Runnable {

    int x, y, tx, ty;//x o y x va y e lule hastand
   final int g = 10;
    int v1 = 100;//power of tankbadan az player gerefte mishavad;
    int power = 0;
    ImageIcon bullet;
    int t=0;//zamane harekate golule;

    public Bullet(int x, int y) {
        this.x = x;//x o y lule tank
        this.y = y;
        bullet = new ImageIcon("bullet.png");
    

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageIcon getPic() {
        return bullet;
    }

    @Override
    public void run() {
        while(y<600){
            t+=(1/10);
        y = ((-1/2)*g*t*t)+ (v1*g*t)+ y;
        x = (v1*x*t)+ x;
        }
    }
    }
    


   

    

