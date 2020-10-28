
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sun.java2d.pipe.DrawImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahtab
 */
public class GamePanel extends JPanel implements Runnable, KeyListener, MouseMotionListener,
        MouseListener {

    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    ImageIcon image4;

    ImageIcon image;
    ImageIcon redtank1;
    ImageIcon redtank2;
    ImageIcon bluetank1;
    ImageIcon bluetank2;
    ImageIcon greentank1;
    ImageIcon greentank2;

    JTextField j1;

    int rand, rand1, rand2;
    int x1, y1, x2, y2, dx = 0, dy = 0;
    String tankPlayer1;
    String tankPlayer2;
    private double atan;
    private double dir;

    //false:nobateshe.true=nobaesh nist
    boolean action1 = false, action2 = true;

    public GamePanel(String tankPlayer1, String tankPlayer2) {
        image1 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/pic1.jpg");
        image2 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/pic2.jpg");
        image3 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/pic3.jpg");
        image4 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/pic4.jpg");
        image = new ImageIcon();

        redtank1 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/redtank1.png");
        redtank2 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/redtank2.png");
        bluetank1 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/bluetank1.png");
        bluetank2 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/bluetank2.png");
        greentank1 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/greentank1.png");
        greentank2 = new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/greentank2.png");

        x1 = (int) ((Math.random() * 720) + 280);
        y1 = (int) ((Math.random() * 120) + 280);
        // x1 = (int) ((Math.random() * 1000) + 60);
        // x1 = (int) ((Math.random() * 1000) + 60);

        rand1 = (int) ((Math.random() * 4) + 1);
        if (rand1 == 1) {
            x2 = x1 + 300;
            y2 = y1 + 230;
            System.out.println("1");
        }
        if (rand1 == 2) {
            x2 = x1 + 200;

            y2 = y1 - 200;
            System.out.println("2");
        }
        if (rand1 == 3) {
            x2 = x1 - 200;
            y2 = y1 - 200;
            System.out.println("3");

        }

        if (rand1 == 4) {
            x2 = x1 - 200;
            y2 = y1 + 200;
            System.out.println("4");

        }

        rand = (int) ((Math.random() * 4) + 1);
        if (rand == 1) {
            // System.out.println("1");
            image = image1;
        }
        if (rand == 2) {
            //System.out.println("2");
            image = image2;
        }
        if (rand == 3) {
            // System.out.println("3");
            image = image3;
        }

        if (rand == 4) {
            // System.out.println("3");
            image = image4;
        }
        //addMouseListener(this);
        this.setLayout(null);
        this.setSize(1340, 700);
        this.setLocation(0, 0);
        addMouseMotionListener(this);
        addMouseListener(this);
        this.setVisible(true);

        //  repaint();
        j1 = new JTextField();
        j1.setSize(0, 0);
        j1.setLocation(0, 0);
        add(j1);
        j1.addKeyListener(this);
    }

    @Override

    public void paintComponent(Graphics g) {
        //System.out.println("entering paint function");
        super.paintComponent(g);
        //System.out.println("here");
        g.drawImage(image.getImage(), 0, 0, 1340, 700, null);
        g.drawImage(greentank1.getImage(), x1, y1, 80, 80, null);
        g.drawImage(redtank2.getImage(), x2, y2, 80, 80, null);

        if (action2) {
            if (dx < 0) {
                if (x1 > 80) {
                    x1 += dx;
                    g.drawImage(greentank1.getImage(), x1, y1, 80, 80, null);
                    // action1 = true;
                    //action2 = false;
                }
            } else if (dx > 0) {
                if (x1 < 1200) {
                    x1 += dx;
                    g.drawImage(greentank1.getImage(), x1, y1, 80, 80, null);
                    //action1 = true;
                    //action2 = false;
                }
            }
            action1 = true;
            action2 = false;
        }

        if (action1) {
            if (dx < 0) {
                if (x2 > 80) {

                    x2 += dx;
                    g.drawImage(redtank2.getImage(), x2, y2, 80, 80, null);
                    // action2 = true;
                    //  action1 = false;
                }
            } else if (dx > 0) {
                if (x2 < 1200) {
                    x2 += dx;
                    g.drawImage(redtank2.getImage(), x2, y2, 80, 80, null);
                    // action2 = true;
                    // action1 = false;
                }

            }
            action2 = true;
            action1 = false;
        }//mouse for tank nuber1;
        BufferedImage lDefaaiiImage = new BufferedImage(500, 500,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = lDefaaiiImage.createGraphics();
        g2.rotate(Math.toRadians(atan), x1, y1);
        g2.drawImage(greentank1.getImage(), x1 - 18, y1 - 20, 30, 100, null);
        g.drawImage(lDefaaiiImage, 40, 0, null);
        
        //mouse for tank number2;
         BufferedImage lDefaaiiImage1 = new BufferedImage(500, 500,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g3 = lDefaaiiImage.createGraphics();
        g3.rotate(Math.toRadians(atan), x2, y2);
        g3.drawImage(redtank2.getImage(), x2 - 18, y2 - 20, 30, 100, null);
        g.drawImage(lDefaaiiImage, 40, 0, null);

		//g2.rotate(Math.toRadians(atan), x1, y1);
        //  g2.drawImage(greentank1.getImage(),x1,y1, null);
        //  g2.rotate(-Math.toRadians(atan), x1, y1);
    }

    @Override
    public void run() {

        while (true) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
 //               Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
   //         }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
       // System.out.println("m");
        double f = 0;
        if (arg0.getX() >= x1 && arg0.getY() < y1) {
            f = (double) (y1 - arg0.getY()) / (double) (arg0.getX() - x1);
            atan = -1 * ((x1 * Math.atan(f)) / 3.14) - 90;
        }
        if (arg0.getX() < x1 && arg0.getY() < y1) {
            f = (double) (y1 - arg0.getY()) / (double) (x1 - arg0.getX());
            atan = ((180 * Math.atan(f)) / 3.14) + 90;
        }
        
          if (arg0.getX() >= x2 && arg0.getY() < y2) {
            f = (double) (y2 - arg0.getY()) / (double) (arg0.getX() - x2);
            atan = -1 * ((x2 * Math.atan(f)) / 3.14) - 90;
        }
        if (arg0.getX() < x2 && arg0.getY() < y2) {
            f = (double) (y2 - arg0.getY()) / (double) (x2 - arg0.getX());
            atan = ((180 * Math.atan(f)) / 3.14) + 90;
        }
        dir = f;

    }

    /*    @Override
     public void mouseClicked(MouseEvent arg0) {

     boolean flag = false;
     if (arg0.getX() > 180) {
     flag = true;
     }
     Bullet b = new Bullet(180, 240, arg0.getY(), dir, flag, en1, en2, eb,
     vecbull, vex, this);
     (new Thread(b)).start();
     vecbull.add(b);

     }*/
    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }
}
