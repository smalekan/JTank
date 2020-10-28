
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahtab
 */
class JTank extends JFrame implements ActionListener {
//JButton b1;

    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel red1;
    JLabel red2;
    JLabel blue1;
    JLabel blue2;
    JLabel green1;
    JLabel green2;

    JTextField name1;
    JTextField name2;
    JRadioButton[] colors1;
    JRadioButton[] colors2;
    JButton start, exit;
        static String s;


    public JTank() {
        setTitle("Tank Game!!!");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

       
// Another way
        setLayout(new BorderLayout());
        // setContentPane(new JLabel(new ImageIcon("resources/taverna.jpg")));
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Mahtab\\Documents\\NetBeansProjects\\JTank\\src/123.jpg")));
        setLayout(null);
        l1 = new JLabel("Player1 name:");
        l1.setSize(200, 30);
        l1.setLocation(50, 20);
        l1.setFont(new Font("Monospaced", Font.PLAIN, 18));
        l1.setForeground(Color.red);
        l2 = new JLabel("player2 name:");
        l2.setSize(200, 20);
        l2.setLocation(50, 80);
        l2.setFont(new Font("Monospaced", Font.PLAIN, 18));
        l2.setForeground(Color.red);
        l3 = new JLabel("Player1 tank color:");
        l3.setSize(400, 30);
        l3.setLocation(50, 140);
        l3.setFont(new Font("Monospaced", Font.PLAIN, 18));
        l3.setForeground(Color.red);
        l4 = new JLabel("Player2 tank color:");
        l4.setSize(400, 30);
        l4.setLocation(50, 380);
        l4.setFont(new Font("Monospaced", Font.PLAIN, 18));
        l4.setForeground(Color.red);
        red1 = new JLabel("Red");
        red1.setSize(50, 30);
        red1.setLocation(100, 188);
        red1.setFont(new Font("Monospaced", Font.PLAIN, 18));
        red1.setForeground(Color.red);

        red2 = new JLabel("Red");
        red2.setSize(50, 30);
        red2.setLocation(100, 429);
        red2.setFont(new Font("Monospaced", Font.PLAIN, 18));
        red2.setForeground(Color.red);

        blue1 = new JLabel("Blue");
        blue1.setSize(70, 30);
        blue1.setLocation(100, 250);
        blue1.setFont(new Font("Monospaced", Font.PLAIN, 18));
        blue1.setForeground(Color.blue.darker().darker());

        blue2 = new JLabel("Blue");
        blue2.setSize(70, 30);
        blue2.setLocation(100, 490);
        blue2.setFont(new Font("Monospaced", Font.PLAIN, 18));
        blue2.setForeground(Color.blue.darker().darker());

        green1 = new JLabel("Green");
        green1.setSize(70, 30);
        green1.setLocation(100, 310);
        green1.setFont(new Font("Monospaced", Font.PLAIN, 18));
        green1.setForeground(Color.green);

        green2 = new JLabel("Green");
        green2.setSize(70, 30);
        green2.setLocation(100, 549);
        green2.setFont(new Font("Monospaced", Font.PLAIN, 18));
        green2.setForeground(Color.green);

       
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(l3);
        getContentPane().add(l4);
        getContentPane().add(red1);
        getContentPane().add(red2);
                getContentPane().add(blue1);
        getContentPane().add(green1);
                getContentPane().add(blue2);
                                getContentPane().add(green2);




        name1 = new JTextField();
        name1.setSize(80, 25);
        name1.setLocation(200, 20);
        name1.setText("Player Name");
        name1.selectAll();
        //name.addFocusListener(this);
        getContentPane().add(name1);

        name2 = new JTextField();
        name2.setSize(80, 25);
        name2.setLocation(200, 80);
        name2.setText("Player Name");
        name2.selectAll();
        getContentPane().add(name2);
        name2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode()== KeyEvent.VK_ENTER)
               
                s = name2.getText();
            }
        });
                

        colors1 = new JRadioButton[3];
        colors1[0] = new JRadioButton("Red");
        colors1[1] = new JRadioButton("Black");
        colors1[2] = new JRadioButton("Green");

        for (int i = 0; i <= 2; i++) {
            colors1[i].setSize(15, 10);
        }

        colors1[0].setLocation(50, 200);
        colors1[1].setLocation(50, 260);
        colors1[2].setLocation(50, 320);

        for (int i = 0; i <= 2; i++) {
            getContentPane().add(colors1[i]);
        }

        // for (int i1 = 0; i1 <= 2; i1++) {
        //colors1[i].setLocation(i1, i1);
        //}
        colors2 = new JRadioButton[3];
        colors2[0] = new JRadioButton("Red");
        colors2[1] = new JRadioButton("Black");
        colors2[2] = new JRadioButton("Green");
        for (int i = 0; i <= 2; i++) {
            colors2[i].setSize(15, 10);
        }

        colors2[0].setLocation(50, 440);
        colors2[1].setLocation(50, 500);
        colors2[2].setLocation(50, 560);

        for (int i = 0; i <= 2; i++) {
            getContentPane().add(colors2[i]);
        }
        
        
		start = new JButton("START");
		start.setSize(80, 40);
		start.setLocation(1150, 20);
		start.setBackground(Color.GRAY);
                start.addActionListener(this);
		getContentPane().add(start);
                

		exit = new JButton("EXIT");
		exit.setSize(80, 40);
		exit.setLocation(1250, 20);
		exit.setBackground(Color.GRAY);
		getContentPane().add(exit);
                
                
                exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int reply = JOptionPane.showConfirmDialog(null,
						"u wanna exit?!!:(((((", "EXIT-CONFIRM",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					dispose();
					System.exit(0);
				}

			}
		});

        // Just for refresh.Not optional!
        setSize(500, 500);
        setSize(1000, 1000);
    }

   
    public static void main(String args[]) {
        new JTank();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){
            GameFrame gameframe = new GameFrame(name1.getText(),name2.getText());//text.getText()
            this.dispose();
        }
    }
}
