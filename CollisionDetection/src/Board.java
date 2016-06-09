import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Random;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Frog frog;
    private Image myBackground;
    private ArrayList<Obstacle> obstacles;
    private boolean ingame;
    private final int B_WIDTH = 1000;
    private final int B_HEIGHT = 800;
    private final int FROG_X = B_WIDTH/2 - 90; // 500 - 90, 410 x zaby 
    private final int FROG_Y = B_HEIGHT - 90;	//710 pozycja y zaby
    private final int DELAY = 15;

    
    private final int[][] pos = {
        {500, 220}, {200, 320}//,  //2 prawe pasy
        //{400, 420}, {600, 520}, //2 lewe
    };

    

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        frog = new Frog(FROG_X, FROG_Y);
        
        ImageIcon ii = new ImageIcon("bg_honzik.png");
        myBackground = ii.getImage();

        initAliens();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initAliens() {
    	obstacles = new ArrayList<>();
        
        

        for (int[] p : pos) {
            obstacles.add(new Obstacle(p[0], p[1]));
        }
    }

    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

        	g.drawImage(myBackground, 0, 0, this);
            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (frog.isVisible()) {
            g.drawImage(frog.getImage(), frog.getX(), frog.getY(),
                    this);
        }

        for (Obstacle a : obstacles) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
     //   g.drawString("Aliens left: " + obstacles.size(), 5, 15);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateCraft();
        updateAliens();

        checkCollisions();

        repaint();
    }

    private void inGame() {
        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCraft() {

        if (frog.isVisible()) {
            frog.move();
        }
    }


    private void updateAliens() {

        if (obstacles.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < obstacles.size(); i++) {

        	Obstacle a = obstacles.get(i);
            if (a.isVisible()) {
                a.moveLeft();
            } else {
                obstacles.remove(i);
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = frog.getBounds();

        for (Obstacle obstacle : obstacles) {
            Rectangle r2 = obstacle.getBounds();

            if (r3.intersects(r2)) {
                frog.setVisible(false);
                obstacle.setVisible(false);
                ingame = false;
            }
        }


    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            frog.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            frog.keyPressed(e);
        }
    }
}